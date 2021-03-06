from django.contrib import admin
from apotheker.models import Activesubstance, Distributor, Manufacturer, Medicaldrug, MedicaldrugActivesubstance, Patient, Prescription, Prescriptionitem, Report, User

class MedicalDrugAdmin(admin.ModelAdmin):
    search_fields = ('name',)

admin.site.register(Activesubstance)
admin.site.register(Distributor)
admin.site.register(Manufacturer)
admin.site.register(Medicaldrug, MedicalDrugAdmin)
admin.site.register(MedicaldrugActivesubstance)
admin.site.register(Patient)
admin.site.register(Prescription)
admin.site.register(Prescriptionitem)
admin.site.register(Report)
admin.site.register(User)

