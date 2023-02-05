from django.db import models

# Create your models here.
class Paciente (models.Model):
    nombre= models.CharField(max_length=80)
    cedula = models.IntegerField()
    fecha_nacimiento= models.DateField(auto_now=False, auto_now_add=False)
    telefono = models.CharField(max_length=90)
    correo = models.CharField(max_length=90)
    
class Especialista (models.Model):
    nombre= models.CharField(max_length=80)
    cedula = models.IntegerField()
    fecha_nacimiento= models.DateField(auto_now=False, auto_now_add=False)
    telefono = models.CharField(max_length=90)
    correo = models.CharField(max_length=90)
    especialidad = models.CharField(max_length=80)
