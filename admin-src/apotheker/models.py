# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#     * Rearrange models' order
#     * Make sure each model has one field with primary_key=True
# Feel free to rename the models, but don't rename db_table values or field names.
#
# Also note: You'll have to insert the output of 'django-admin.py sqlcustom [appname]'
# into your database.

from django.db import models

class Activesubstance(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    name = models.CharField(max_length=765, db_column='NAME', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'ACTIVESUBSTANCE'
    
    def __unicode__(self):
        return self.name

class Distributor(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    name = models.CharField(max_length=765, db_column='NAME', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'DISTRIBUTOR'
        
    def __unicode__(self):
        return self.name
class Manufacturer(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    name = models.CharField(max_length=765, db_column='NAME', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'MANUFACTURER'
        
    def __unicode__(self):
        return self.name

class Medicaldrug(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    dailydemand = models.IntegerField(null=True, db_column='DAILYDEMAND', blank=True) # Field name made lowercase.
    name = models.CharField(max_length=765, db_column='NAME', blank=True) # Field name made lowercase.
    stock = models.IntegerField(null=True, db_column='STOCK', blank=True) # Field name made lowercase.
    swissmedicnumber = models.CharField(max_length=765, db_column='SWISSMEDICNUMBER', blank=True) # Field name made lowercase.
    distributor_id = models.BigIntegerField(null=True, db_column='DISTRIBUTOR_ID', blank=True) # Field name made lowercase.
    manufacturer_id = models.BigIntegerField(null=True, db_column='MANUFACTURER_ID', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'MEDICALDRUG'
        
    def __unicode__(self):
        return self.name

class MedicaldrugActivesubstance(models.Model):
    medicaldrug_id = models.AutoField(primary_key=True, db_column='MedicalDrug_ID') # Field name made lowercase.
    activesubstances_id = models.BigIntegerField(db_column='activeSubstances_ID') # Field name made lowercase.
    class Meta:
        db_table = u'MEDICALDRUG_ACTIVESUBSTANCE'

class Patient(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    birthday = models.DateField(null=True, db_column='BIRTHDAY', blank=True) # Field name made lowercase.
    firstname = models.CharField(max_length=765, db_column='FIRSTNAME', blank=True) # Field name made lowercase.
    lastname = models.CharField(max_length=765, db_column='LASTNAME', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'PATIENT'
    
    def __unicode__(self):
        return self.firstname + ' ' + self.lastname

class Prescription(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    date = models.DateField(null=True, db_column='DATE', blank=True) # Field name made lowercase.
    doctor = models.CharField(max_length=765, db_column='DOCTOR', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'PRESCRIPTION'

class Prescriptionitem(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    enddate = models.DateField(null=True, db_column='ENDDATE', blank=True) # Field name made lowercase.
    evening = models.IntegerField(null=True, db_column='EVENING', blank=True) # Field name made lowercase.
    morning = models.IntegerField(null=True, db_column='MORNING', blank=True) # Field name made lowercase.
    night = models.IntegerField(null=True, db_column='NIGHT', blank=True) # Field name made lowercase.
    noon = models.IntegerField(null=True, db_column='NOON', blank=True) # Field name made lowercase.
    startdate = models.DateField(null=True, db_column='STARTDATE', blank=True) # Field name made lowercase.
    medicaldrug_id = models.BigIntegerField(null=True, db_column='MEDICALDRUG_ID', blank=True) # Field name made lowercase.
    prescription_id = models.BigIntegerField(null=True, db_column='PRESCRIPTION_ID', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'PRESCRIPTIONITEM'

class Report(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    text = models.CharField(max_length=765, db_column='TEXT', blank=True) # Field name made lowercase.
    prescriptionitem_id = models.BigIntegerField(null=True, db_column='PRESCRIPTIONITEM_ID', blank=True) # Field name made lowercase.
    user_id = models.BigIntegerField(null=True, db_column='USER_ID', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'REPORT'

class User(models.Model):
    id = models.AutoField(primary_key=True, db_column='ID') # Field name made lowercase.
    password = models.CharField(max_length=765, db_column='PASSWORD', blank=True) # Field name made lowercase.
    username = models.CharField(max_length=765, db_column='USERNAME', blank=True) # Field name made lowercase.
    class Meta:
        db_table = u'USER'
    
    def __unicode__(self):
        return self.username

