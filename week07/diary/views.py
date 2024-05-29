from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
from django.views.generic import ListView
from .models import Diary

class class_view(ListView):
  model=Diary
  template_name='cbview.html'