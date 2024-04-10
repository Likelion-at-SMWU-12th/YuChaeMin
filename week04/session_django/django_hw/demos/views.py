from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

def helloBabyLion(request):
  # return HttpResponse('숙제 앱')
  return render(request, 'babyhw.html')