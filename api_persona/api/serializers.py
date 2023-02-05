from rest_framework import serializers
from api.models import Especialista, Paciente

class PacienteSerializer (serializers.ModelSerializer):
    class Meta:
        model = Paciente
        fields = "__all__"
        
class EspecialistaSerializer (serializers.ModelSerializer):
    class Meta:
        model = Especialista
        fields = "__all__"        