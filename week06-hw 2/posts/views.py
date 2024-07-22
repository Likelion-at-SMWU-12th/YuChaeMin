from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from rest_framework.viewsets import ModelViewSet

from django.views.generic import ListView
from .models import Post
from .forms import PostBasedForm, PostModelForm, PostDetailForm, PostCreateForm, PostUpdateForm
from .serializers import PostModelSerializer, PostListSerializer, PostRetrieveSerializer, CommentListModelSerializer

from rest_framework.response import Response
from rest_framework.decorators import api_view, action, permission_classes
from rest_framework import generics

from django.contrib.auth import authenticate
from rest_framework.authtoken.models import Token
from rest_framework.permissions import AllowAny, IsAuthenticated, IsAdminUser


# ViewSet
class PostModelViewSet(ModelViewSet):
    queryset=Post.objects.all()
    serializer_class=PostListSerializer
    
    @action(detail=True, methods=['GET'])
    def get_comment_all(self, request, pk=None):
        post=self.get_object()
        comment_all = post.comment_set.all()
        serializer = CommentListModelSerializer(comment_all, many = True)
        return Response(serializer.data)
    
    def get_permissions(self):
        action = self.action
        permission_classes = []
        if action == 'list' :
            permission_classes = [AllowAny]
        elif action == 'create':
            permission_classes = [IsAuthenticated]
        elif action == 'retrieve':
            permission_classes = [IsAuthenticated]
        elif action == 'update':
            permission_classes = [IsAdminUser]
        elif action == 'partial_update':
            permission_classes = [IsAdminUser]
        elif action == 'destroy':
            permission_classes = [IsAdminUser]
        return [permission() for permission in permission_classes]

# 게시글 목록 + 생성
class PostListCreateView(generics.ListAPIView, generics.CreateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostListSerializer

# 게시글 상세-new!
class PostRetrieveUpdateView(generics.RetrieveAPIView, generics.UpdateAPIView, generics.DestroyAPIView):
    queryset = Post.objects.all()
    serializer_class = PostRetrieveSerializer

# queryset의 리스트를 보여주는 뷰
# 게시글 목록 + 생성
class PostListView(generics.ListAPIView, generics.CreateAPIView):
    queryset=Post.objects.all()
    serializer_class = PostListSerializer# 쿼리셋과 시리얼라이저를 사용하겠다~

# 게시글 상세
class PostRetrieveView(generics.RetrieveAPIView):
    queryset = Post.objects.all()
    serializer_class = PostRetrieveSerializer

class PostModelViewSet(ModelViewSet):
    queryset=Post.objects.all()
    serializer_class=PostListSerializer # 모델 뷰셋 사용하게 정의

# 게시글 수정
# UpdateAPIView- 아까 목록+생성과 동일하게.. 글을 보여줘야 수정할 수 있으니까!
# class PostUpdateView(generics.UpdateAPIView):
#     queryset = Post.objects.all()
#     serializer_class = PostListSerializer

# 사용자 인증 구현
@api_view(['POST'])
@permission_classes(AllowAny)
def login_view(request):
    username = request.POST['username']
    password = request.POST['password']
    user = authenticate(request,
                        username=username,
                        password=password,)
    if user:
        token, _ = Token.objects.get_or_create(user=user)
        return Response({'token':token.key})
    else:
        return Response(status=401)



@api_view(['GET'])
def calculator(request):
    num1=request.GET.get('num1', 0) # 기본값 0
    num2=request.GET.get('num2', 0) # 기본값 0
    operator=request.GET.get('operator') # 없으면 null
    
    if operator == '+':
        result = int(num1) + int(num2)
    elif operator == '-':
        result = int(num1) - int(num2)
    elif operator == '*':
        result = int(num1) * int(num2)
    elif operator == '/':
        result = int(num1) / int(num2)
    else:
        result = 0

    # 사용된 연산자와 결과를 JSON 형식{'키' : '값'}으로 반환
    data = {
        'operator' : operator,
        'result' : result
    }
    return Response(data)


def index(request):
    return render(request, 'index.html')

def post_list_view(request):
    return render(request, 'posts/post_list.html')

def post_detail_view(request, id):
    return render(request, 'posts/post_detail.html')

def post_detail_form_view(request, id):
    try:
        post = Post.objects.get(id=id)
    except Post.DoesNotExist:
        return redirect('index')
    context={
        'post': post,
        'form': PostDetailForm(),
    }
    return render(request, 'posts/post_detail.html', context)

def post_create_view(request):
    return render(request, 'posts/post_form.html')

def post_form_view(request):
    if request.method == "GET":
        form = PostBasedForm() # post_form_view(얘를 같이 줄거임) 생성 -> PostBasedForm 사용
        context = {'form': form}
        return render(request, 'posts/post_form2.html', context) # post_form2를 렌더링 할거임
    else:
        return redirect('index')
    
def post_create_form_view(request):
    if request.method == "GET":
        form = PostModelForm() # 폼을 써서 생성
        context = {'form': form}
        return render(request, 'posts/post_form2.html', context)
    else:
        form = PostModelForm(request.POST, request.FILES)

        if form.is_valid(): # 유효성을 검사하는 코드
            Post.objects.create( # 포스트 요청이 와서 또 폼을 주고 (위 if로 올라가서)
                image = form.cleaned_data['image'],
                content = form.cleaned_data['content'],
                writer = request.user
            )
        else:
            return redirect('post:post-new')
        return redirect('index')

def post_update_view(request, id):
    return render(request, 'posts/post_update.html')

def post_delete_view(request, id):
    return render(request, 'posts/post_confirm_delete.html')

class class_view(ListView):
    model=Post
    template_name='cbv_view.html'

def url_view(request):
    data={'code':'001','msg':'OK'}
    return HttpResponse('<h1>url_views</h1>')

def url_parameter_view(request, username):
    print('url_parameter_view()')
    print(f'username: {username}')
    print(f'request.GET:{request.GET}')
    return HttpResponse(username)

def function_view(request):
    print(f'request.method:{request.method}')
    if request.method =="GET":
        print(f'request.GET:{request.GET}')
    elif request.method == "POST":
        print(f'request.POST:{request.POST}')
    return render(request,'view.html')

    # print(f'request.GET: {request.GET}')
    # print(f'request.POST:{request.POST}')
    # return render(request, 'view.html')
