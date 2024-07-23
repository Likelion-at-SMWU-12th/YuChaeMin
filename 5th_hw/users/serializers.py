from django.contrib.auth.models import User
from django.contrib.auth.password_validation import validate_password

from rest_framework import serializers
from rest_framework.authtoken.models import Token
from rest_framework.validators import UniqueValidator # 이메일 중복 방지

#로그인을 위해 추가
from django.contrib.auth import authenticate

from .models import Profile

# 회원가입 시리얼라이저
class RegisterSerializer(serializers.ModelSerializer):
  email = serializers.EmailField(
    required=True,
    validators=[UniqueValidator(queryset=User.objects.all())],
  )
  password = serializers.CharField(
    write_only=True,
    required=True,
    validators=[validate_password],
  )
  password2 = serializers.CharField(write_only= True, required=True,) #비밀번호 확인을 위한 필드
  
  class Meta:
    model = User
    fields = ('username', 'password', 'password2', 'email')
    
  def validate(self, data):
    if data['password']!=data['password2']:
      raise serializers.ValidationError(
        {"password": "Password field don't match"}
      )
    return data
    
  def create(self, validated_data):
    user = User.objects.create_user(
      username=validated_data['username'],
      email = validated_data['email'],
    )
    user.set_password(validated_data['password'])
    user.save()
    token=Token.objects.create(user=user)
    return user

# 로그인 시리얼라이저
class LoginSerializer(serializers.Serializer):
  username = serializers.CharField(required=True)
  password = serializers.CharField(required=True, write_only=True)
  # write_only옵션을 통해 클라이언트->서버 방향의 역직렬화는 가능, 서버->클라이언트 방향의 직렬화는 불가능
  
  def validate(self,data):
    user = authenticate(**data)
    if user:
      token = Token.objects.get(user=user)
      return token
    raise serializers.ValidationError(
      {"error": "Unable to log in with provided credentials"}
    )

class ProfileSerializer(serializers.ModelSerializer):
  class Meta:
    model = Profile
    fields = ("nickname", "position", "subjects", "image")