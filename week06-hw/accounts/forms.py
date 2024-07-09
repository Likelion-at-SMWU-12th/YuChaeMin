from django import forms
from django.contrib.auth import get_user_model
from django.contrib.auth.forms import UserCreationForm

class UserBasedForm(forms.ModelForm):
    class Meta:
        model = get_user_model()
        fields = '__all__'

class UserCreateForm(UserBasedForm):
    password2 = forms.CharField(widget=forms.PasswordInput)
    class Meta(UserBasedForm.Meta):
        fields=['username', 'email', 'phone', 'password']

class SignUpForm(UserCreationForm):
    class Meta(UserCreationForm.Meta):
        model = get_user_model() # settings.py에다가 유저 모델.. Posts할때는 이름을 주었으나 세팅스점파이에 설정해놓은걸 사용하겠다는 말...
        fields = ['username', 'email']

