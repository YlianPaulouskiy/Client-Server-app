from django.db import models


# Create your models here.

class Car(models.Model):
    mark = models.CharField(max_length=200)

    doorCount = models.IntegerField()

    accounting = models.BooleanField()

    def __str__(self):
        return self.mark
