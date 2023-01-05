from rest_framework.routers import DefaultRouter
from api.views import PacienteViewSet, CitaViewSet

router = DefaultRouter()
router.register('api/paciente', PacienteViewSet)
router.register('api/cita', CitaViewSet)

urlpatterns = []
urlpatterns += router.urls