# Generated by Django 5.0.6 on 2024-05-29 01:10

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('diary', '0002_alter_diary_image'),
    ]

    operations = [
        migrations.AlterField(
            model_name='diary',
            name='image',
            field=models.ImageField(blank=True, null=True, upload_to='media/images/', verbose_name='오늘의 사진'),
        ),
    ]