# Generated by Django 5.0.6 on 2024-05-28 00:12

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('todolist', '0002_diary_alter_todolist_detail_alter_todolist_todo'),
    ]

    operations = [
        migrations.DeleteModel(
            name='Diary',
        ),
    ]
