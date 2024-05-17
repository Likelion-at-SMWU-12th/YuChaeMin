from django.db import models

# Create your models here.
class UserGroup (models.Model):
  image = models.ImageField(verbose_name='프로필사진')
  username = models.TextField('유저 아이디')
  joined_at = models.DateTimeField('가입 날짜')
  post_num = models.IntegerField('게시물 개수')