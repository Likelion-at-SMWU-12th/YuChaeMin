from django.contrib import admin
from .models import Post
from .models import Comment

# # Register your models here.
# admin.site.register(Post)

class CommentInLine(admin.TabularInline): # StackedInline도 사용 가능
  model = Comment
  extra = 5
  min_num = 3
  max_num = 5
  verbose_name = '댓글'
  verbose_name_plural = '댓글들'

class PostModelAdmin(admin.ModelAdmin):
  # model에 있는 필드를 원하는만큼 리스트 내에 작성!
  list_display = ['id', 'image', 'contentn', 'created_at', 'view_count', 'writer']
  list_editable = ['contentn', 'writer']
  list_filter = ['created_at']
  search_fields = ['id', 'writer_username']
  search_help_text = '게시판번호, 작성자 검색이 가능합니다'
  readonly_fields = ['view_count', 'created_at']
  inlines = [CommentInLine]
  actions=['report']
  def report(modeladmin, request, queryset):
    for item in queryset:
      item.contentn='운영규칙 위반으로 인한 게시글 삭제 처리'
      item.save()

admin.site.register(Post, PostModelAdmin)