from django.contrib import admin
from django.urls import path, include

from posts.views import url_view, url_parameter_view, function_view, class_view
from posts.views import index #방금 만든 인덱스 임포트해서 넣어주고 #posts>urls.py의 url을 posts/뒤에 붙이도록 만들음
from posts.views import calculator
from posts.views import PostListView, PostRetrieveView, PostListCreateView, PostRetrieveUpdateView,PostModelViewSet

from django.conf.urls.static import static
from django.conf import settings

from rest_framework import routers

router = routers.DefaultRouter()
router.register('posts', PostModelViewSet)

urlpatterns = [
    path('', include(router.urls)),
    path('posts/', PostListCreateView.as_view()),
    path('posts/<int:pk>/', PostRetrieveUpdateView.as_view()),
    # path('posts/', PostListView.as_view()),
    # path('posts/<int:pk>/', PostRetrieveView.as_view()),
    path('calculator/', calculator),
    path('admin/', admin.site.urls),
    path('url/', url_view),
    path('url/<str:username>/', url_parameter_view),
    path('fbv/', function_view),
    path('cbv/', class_view.as_view()),

    path('', index, name='index'),
    # path('posts/', include('posts.urls', namespace='posts')), 
    path('accounts/', include('accounts.urls', namespace='accounts')), 
]

urlpatterns += static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)