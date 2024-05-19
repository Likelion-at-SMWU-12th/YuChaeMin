## 멋사 6주차 과제
---
### MTV 사건
2009년 MTV VMA에서 칸예(View)가 테일러(Client)에게 "비욘세가 상을 타야했다"고 전한(응답을 반환) 사건이다
![mtvvma-깃](https://github.com/Likelion-at-SMWU-12th/YuChaeMin/assets/113892409/2a28c0f0-f856-4a77-8042-35eb53c9c370)

### MTV 패턴
MTV 패턴은 Django 웹 프레임워크에서 사용되는 디자인 패턴
MTV 패턴은 애플리케이션의 구성 요소를 Model, Template, View로 분리하여 코드의 가독성과 유지보수성을 높인다
1. Model
  - 데이터베이스와 상호작용하는 부분을 담당
  - 데이터의 구조와 관계를 정의하는 클래스로 구성
  - Django의 ORM(Object-Relational Mapping)을 통해 데이터베이스 테이블과 매핑
  - 모델은 데이터의 유효성 검사, 쿼리 생성, 데이터 조작 등의 기능을 제공
2. Template
  - 사용자에게 보여지는 UI(User Interface)를 담당
  - HTML, CSS, JavaScript 등을 사용하여 동적으로 페이지를 렌더링
  - 장고 템플릿 언어(Django Template Language)를 사용하여 뷰에서 전달된 데이터를 표시
  - 템플릿은 프레젠테이션 로직을 담당하며, 뷰에서 전달된 데이터를 기반으로 동적인 웹 페이지를 생성
3. View
  - 사용자의 요청을 처리하고 클라이언트에게 응답을 반환하는 부분을 담당 (클라이언트와 가장 가깝다)
  - HTTP 요청을 받아 해당 요청에 맞는 처리를 수행
  - 필요한 데이터를 모델에서 가져오고, 템플릿에 전달하여 최종 응답을 생성
  - 비즈니스 로직과 데이터 처리를 담당하며, 요청에 따라 적절한 템플릿을 선택하고 렌더링
<img width="625" alt="mtv" src="https://github.com/Likelion-at-SMWU-12th/YuChaeMin/assets/113892409/870f0c24-23cd-4ee6-961d-2d4d02984e40">
