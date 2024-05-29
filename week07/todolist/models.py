from django.db import models

# Create your models here.

class Todolist (models.Model):
  todo = models.TextField(verbose_name='todo', max_length=100)
  done = models.BooleanField(default=False) # todo를 했냐 안했냐
  uploaded = models.DateField(auto_now_add=True) # todo를 등록한 일시
  detail = models.TextField(verbose_name='details', max_length=300) # todo에 대한 상세 설명을 할 수 있게
