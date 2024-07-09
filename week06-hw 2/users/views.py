from django.shortcuts import render, redirect
from .forms import SignUpForm
from django.contrib.auth.forms import AuthenticationForm
from django.contrib.auth import login, logout

from django.contrib.auth import authenticate, login, logout
from rest_framework.decorators import api_view
from rest_framework.response import Response

from .models import User
from .serializers import UserModelSerializer, SignupSerializer, LoginSerializer

def signup_view(request):
    # GET 요청 시 HTML 응답
    if request.method =='GET':
        form = SignUpForm
        context = {'form':form}
        return render(request, 'accounts/signup.html', context)
    
    # POST 요청 시 데이터 확인 후 회원 생성
    else:
        form = SignUpForm(request.POST)

        if form.is_valid():
            instance = form.save()
            return redirect('index')
        else:
            return redirect('accounts:signup')

def login_view(request):
    #GET, POST 분리
    if request.method == "GET": # 로그인 HTML 응답
        return render(request, 'accounts/login.html', {'form': AuthenticationForm()})
    else:
        form = AuthenticationForm(request, request.POST) # 데이터 유효성 검사
        if form.is_valid():
            login(request, form.user_cache) # 로그인 처리
            return redirect('index')
        else:
            return render(request, 'accounts/login.html', {'form':form})

def logout_view(request):
    # 데이터 유효성 검사
    if request.user.is_authenticated:
        logout(request)
    return redirect('index')

@api_view(['POST'])
def signup(request):
    serializer = SignupSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
        return Response({'message': 'User created successfully'}, status=201)
    return Response(serializer.errors, status=400)

@api_view(['POST'])
def login_view(request):
    serializer = LoginSerializer(data=request.data)
    if serializer.is_valid():
        username = serializer.validated_data['username']
        password = serializer.validated_data['password']
        user = authenticate(username=username, password=password)
        if user:
            login(request, user)
            user_serializer = UserModelSerializer(user)
            return Response(user_serializer.data)
    return Response({'error': 'Invalid credentials'}, status=400)

@api_view(['POST'])
def logout_view(request):
    logout(request)
    return Response({'message': 'Logout successful'})

@api_view(['GET', 'PUT', 'DELETE'])
def user_detail(request):
    user = request.user
    if not user.is_authenticated:
        return Response({'error': 'Not authenticated'}, status=401)

    if request.method == 'GET':
        serializer = UserModelSerializer(user)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = UserModelSerializer(user, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=400)

    elif request.method == 'DELETE':
        user.delete()
        return Response({'message': 'User deleted successfully'}, status=204)