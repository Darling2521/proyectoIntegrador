from rest_framework import viewsets

from api.models import Paciente, Especialista, TipoPersona
from api.serializers import PacienteSerializer, EspecialistaSerializer, TipoPersonaSerializer

from rest_framework.decorators import action
from rest_framework.request import Request
from rest_framework.response import Response
import requests

@action(detail=True, methods=['patch'])
def completardatos(self, request: Request, *args, **kwargs):
    id = kwargs['pk']
    # Consulta de base de datos el ID solicitado
    paciente = Paciente.objects.get(pk=id)
    # Consulta de la API externa datos segtin el identificador proporcionado
    response = requests.get("https://jsonplaceholder.typicode.com/users/"+id)
    #En caso de una respuesta satisfactoria de la api extema, se procede a completar los datos
    # en base de datos y se retorna la respuesa al cliente
    if response.status_code == 200:
        data = response.json()
        paciente.email = data['email']
        paciente.phone = data['phone']
        paciente.save()
        # Prepara un serializador para mapear la entidad a JSON
        serializer = PacienteSerializer(paciente)
        # Regresa una respuesta http con la nueva data del cliente
        return Response(serializer.data, content_type="application/json")
    else:
        # si hubo un error en la consulta, devolver un mensaje de error
        return Response("Error en la consulta ala API externa”, status=500")
    
class TipoPersonaViewSet (viewsets.ModelViewSet):
    serializer_class = TipoPersonaSerializer
    queryset = TipoPersona.objects.all()
    
class PacienteViewSet (viewsets.ModelViewSet):
    serializer_class = PacienteSerializer
    queryset = Paciente.objects.all()
    
class EspecialistaViewSet (viewsets.ModelViewSet):
    serializer_class = EspecialistaSerializer
    queryset = Especialista.objects.all()
