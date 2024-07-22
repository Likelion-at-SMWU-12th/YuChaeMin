from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse

# Create your views here.

# def url_view(request):
#   return HttpResponse('url.view')

# def url_view(request):
#   data={'code':'001', 'msg':'OK'}
#   return JsonResponse(data)

from django.views.generic import ListView
from .models import Post


class class_view(ListView):
  model = Post
  template_name='cbv_view.html'

def url_view(request):
  data={'code':'001', 'msg':'OK'}
  return HttpResponse('<h1>url_views</h1>')

def url_parameter_view(request, username):
  print('url_parameter_view()')
  print(f'username: {username}')
  print(f'request.GET: {request.GET}')
  return HttpResponse()

def function_view(request):
  print(f'request.method:{request.method}')
  print(f'request.GET:{request.GET}')
  print(f'request.POST:{request.POST}')
  return render(request, 'view.html')
