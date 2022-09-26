from django.urls import path
from .views import CreateCar, GetOneCar, RemoveCar, GetAllCar

urlpatterns = [
    path('create/', CreateCar.as_view(), name='create-car'),
    path('all/', GetAllCar.as_view()),
    path('find/<int:pk>/', GetOneCar.as_view(), name='get-one-car'),
    path('remove/<int:pk>/', RemoveCar.as_view(), name='delete-customer')
]
