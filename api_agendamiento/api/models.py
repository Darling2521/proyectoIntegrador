from django.db import models

# Create your models here.
class Cita (models.Model):
    id_especialista = models.IntegerField()
    horario = models.CharField(max_length=50)
    fecha = models.DateField(auto_now=False, auto_now_add=False)
    

class Paciente (models.Model):
    id_paciente = models.IntegerField()
    id_especialista = models.ForeignKey(Cita, on_delete=models.PROTECT)