from rest_framework.serializers import ModelSerializer
from  .models import Post, Comment

class PostModelSerializer(ModelSerializer):
    class Meta:
        model = Post
        fields = '__all__'
        # fields = ['id', 'writer', 'content']

class PostListSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta): # 안에 .Meta는 왜 쓴겨? 위에는 안썻잖아
        fields= ['id', 'writer', 'content', 'created_at', 'view_count', 'writer']
        depth=1

class PostCreateSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        fields = ['image', 'content']

class PostRetrieveSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        depth=1

class CommentListModelSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'