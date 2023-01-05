from rest_framework import serializers
from api.models import Paciente, Especialista, TipoPersona

class EspecialistaSerializer (serializers.ModelSerializer):
    class Meta:
        model = Especialista
        fields = "__all__"
        
class PacienteSerializer (serializers.ModelSerializer):
    class Meta:
        model = Paciente
        fields = "__all__"
        
class TipoPersonaSerializer (serializers.ModelSerializer):
    class Meta:
        model = TipoPersona
        fields = "__all__"
        
        