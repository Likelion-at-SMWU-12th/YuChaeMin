from django.db import models

# Create your models here.

class Diary (models.Model):
  diary = models.TextField(verbose_name='오늘의 일기')
  uploaded = models.DateTimeField(auto_now_add=True)
  image = models.ImageField(verbose_name='오늘의 사진', null=True, blank=True, upload_to='media/images/')