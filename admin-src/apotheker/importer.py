"""
name
hersteller
wirkstoff
nummer
typ
"""

import csv
import codecs
from apotheker.models import Activesubstance, Medicaldrug, Manufacturer,\
    MedicaldrugActivesubstance

def import_meds():
    f = open('./swissmedic.csv', 'r')
    
    blacklist = [u'Tierarzneimittel', u'Blutprodukte', u'Transplantatprodukte']
    reader = csv.reader(f, dialect=csv.excel)
    
    for row in reader:
        if row[7] in blacklist:
            continue
        number = row[0]
        name = row[2]
        manufracturer = row[3]
        wirkstoff = row[13]
        
        drug = Medicaldrug.objects.create(name=name)
        drug.swissmedicnumber = number
        hersteller, _ = Manufacturer.objects.get_or_create(name=manufracturer)
        drug.manufacturer_id = hersteller.pk
        drug.save()
        
        for sub in wirkstoff.split(','):
            substance, _ = Activesubstance.objects.get_or_create(name=sub.strip())
            ma = MedicaldrugActivesubstance()
            ma.activesubstances_id = substance.id
            ma.medicaldrug_id = drug.id
            ma.save()        
    f.close()



