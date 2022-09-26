from django.shortcuts import render
from .models import Car
from rest_framework import generics
from .serializers import CarSerializer

# Create your views here.
# Save car
class CreateCar(generics.CreateAPIView):
    # API endpoint that allows creation of a new customer
    queryset = Car.objects.all(),
    serializer_class = CarSerializer

# get all cars
class GetAllCar(generics.ListAPIView):
    # API endpoint that allows customer to be viewed.
    queryset = Car.objects.all()
    serializer_class = CarSerializer

# get one Car
class GetOneCar(generics.RetrieveAPIView):
    # API endpoint that returns a single customer by pk.
    queryset = Car.objects.all()
    serializer_class = CarSerializer

# REMOVE
class RemoveCar(generics.RetrieveDestroyAPIView):
    # API endpoint that allows a customer record to be deleted.
    queryset = Car.objects.all()
    serializer_class = CarSerializer