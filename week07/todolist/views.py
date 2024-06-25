from django.shortcuts import render
from django.http import HttpResponse

from django.views.generic import ListView
from .models import Todolist

# Create your views here.
def url_view(request):
  context = { 
    'todo' :  Todolist.objects.all()
  }
  # return render(request, 'fbview.html')
  return render(request, 'fbview.html', context)