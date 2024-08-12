## Spring Annotation 개념 정리
### 컨트롤러 선언
1. @RestController
- RESTful 웹 서비스의 컨트롤러를 나타내는 어노테이션
- @Controller와 @ResponseBody를 결합한 것
- 이 어노테이션이 적용된 클래스의 모든 메서드는 HTTP 응답 본문으로 직접 반환값을 전송

### 요청 매핑
#### 일반매핑
2. @RequestMapping
- 요청 URL을 특정 메서드나 클래스에 매핑하는 데 사용
- 클래스 레벨과 메서드 레벨 모두에서 사용 가능
- URL 패턴, HTTP 메서드, 요청/응답의 미디어 타입 등을 지정할 수 있음
#### HTTP 메서드별 특화 매핑
3. @GetMapping
- HTTP GET 요청을 특정 핸들러 메서드에 매핑
- @RequestMapping(method = RequestMethod.GET)의 축약형

4. @PostMapping
- HTTP POST 요청을 특정 핸들러 메서드에 매핑
- @RequestMapping(method = RequestMethod.POST)의 축약형

5. @PutMapping
- HTTP PUT 요청을 특정 핸들러 메서드에 매핑
- @RequestMapping(method = RequestMethod.PUT)의 축약형

6. @DeleteMapping
- HTTP DELETE 요청을 특정 핸들러 메서드에 매핑
- @RequestMapping(method = RequestMethod.DELETE)의 축약형

### 파라미터 바인딩
7. @PathVariable
- URL 경로에 포함된 변수값을 메서드의 파라미터로 받을 때 사용
- 예: /users/{id}에서 {id} 부분의 값을 추출

8. @RequestParam
- HTTP 요청 파라미터를 메서드의 파라미터로 바인딩
- 주로 쿼리 스트링이나 폼 데이터의 값을 받을 때 사용

### 자바 관련
9. @Override
- 메서드가 상위 클래스나 인터페이스의 메서드를 오버라이드함을 명시적으로 선언
- 컴파일러에게 오버라이드 규칙을 체크하도록 지시

이 어노테이션들을 적절히 조합하여 사용하면 Spring Boot에서 RESTful API를 효과적으로 구현할 수 있습니다.

---

## MTV 개념 정리
### MTV 사건
2009년 MTV VMA에서 칸예(View)가 테일러(Client)에게 "비욘세가 상을 타야했다"고 전한(응답을 반환) 사건이다

<img width="300" alt="Screenshot 2024-05-19 at 11 21 20 AM" src="https://github.com/Likelion-at-SMWU-12th/YuChaeMin/assets/113892409/8d9a7093-3afa-4b55-9413-6d10e0e3cc0f">

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
