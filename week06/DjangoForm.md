# Django Forms: 웹 개발의 강력한 도구 🛠️

## 폼을 사용하여 작업하기 📝

Django에서 폼은 웹 애플리케이션 개발의 핵심 요소입니다. 사용자 입력을 효과적으로 처리하고 검증하는 데 필수적입니다.

### HTML 폼 🌐

HTML 폼은 `<form>...</form>` 태그 내부의 요소들로 구성됩니다. 주요 특징:

- 사용자 입력 수집 (텍스트 입력, 체크박스 등)
- 서버로 데이터 전송
- 두 가지 주요 속성:
  - `action`: 데이터를 보낼 URL
  - `method`: HTTP 메서드 (GET 또는 POST)

### GET과 POST 🔄

1. **GET 메서드**
   - URL에 데이터 포함 (쿼리 문자열)
   - 데이터 길이 제한
   - 북마크 가능
   - 주로 검색 폼에 사용

2. **POST 메서드**
   - 요청 본문에 데이터 포함
   - 더 많은 데이터 전송 가능
   - URL에 데이터 노출 안 됨
   - 주로 로그인, 데이터 수정에 사용

### Django에서의 폼 처리 🐍

Django는 폼 처리를 위한 강력한 도구를 제공합니다:

1. 데이터 준비 및 재구성
2. HTML 폼 생성
3. 클라이언트로부터 제출된 데이터 처리

## Django Form 클래스 📊

Django의 `Form` 클래스는 폼 처리의 핵심입니다.

```python
from django import forms

class NameForm(forms.Form):
    your_name = forms.CharField(label='Your name', max_length=100)
```

- 각 필드는 특정 데이터 유형과 위젯에 매핑
- 자동으로 HTML 생성 및 유효성 검사 수행

### 폼 인스턴스화, 처리 및 렌더링 🔄

1. 뷰에서 폼 인스턴스화
2. 템플릿 컨텍스트로 전달
3. 템플릿에서 HTML로 렌더링

## Django에서 폼 만들기 🏗️

### 필요한 작업

1. 폼 클래스 정의
2. 뷰에서 폼 처리
3. 템플릿 생성

### Form 클래스 정의

```python
from django import forms

class NameForm(forms.Form):
    your_name = forms.CharField(label='Your name', max_length=100)
```

### 뷰에서 폼 처리

```python
from django.http import HttpResponseRedirect
from django.shortcuts import render

from .forms import NameForm

def get_name(request):
    if request.method == 'POST':
        form = NameForm(request.POST)
        if form.is_valid():
            # 데이터 처리
            return HttpResponseRedirect('/thanks/')
    else:
        form = NameForm()
    return render(request, 'name.html', {'form': form})
```

### 템플릿 작성

```html
<form action="/your-name/" method="post">
    {% csrf_token %}
    {{ form }}
    <input type="submit" value="Submit">
</form>
```

- `{% csrf_token %}`: CSRF 공격 방지
- `{{ form }}`: 폼 필드 자동 렌더링
