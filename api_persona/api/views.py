from rest_framework import viewsets

from api.models import Paciente, Especialista
from api.serializers import PacienteSerializer, EspecialistaSerializer

class PacienteViewSet (viewsets.ModelViewSet):
    serializer_class = PacienteSerializer
    queryset = Paciente.objects.all()

class EspecialistaViewSet (viewsets.ModelViewSet):
    serializer_class = EspecialistaSerializer
    queryset = Especialista.objects.all()
# Create your views here.
