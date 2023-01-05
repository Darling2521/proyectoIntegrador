from rest_framework import viewsets

from api.models import Paciente, Cita
from api.serializer import PacienteSerializer, CitaSerializer

class PacienteViewSet (viewsets.ModelViewSet):
    serializer_class = PacienteSerializer
    queryset = Paciente.objects.all()
    
class CitaViewSet (viewsets.ModelViewSet):
    serializer_class = CitaSerializer
    queryset = Cita.objects.all()    