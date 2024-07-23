from django.urls import path
from .views import RegisterView, LoginView, ProfileView

urlpatterns = [
    path('register/', RegisterView.as_view()), #클래스형뷰하서 .as_view해야함
    path('login/', LoginView.as_view()),
    path('profile/<int:pk>/', ProfileView.as_view()),
]
