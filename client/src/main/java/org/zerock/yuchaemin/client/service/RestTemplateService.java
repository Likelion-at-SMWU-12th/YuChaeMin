package org.zerock.yuchaemin.client.service;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.yuchaemin.client.dto.MemberDto;

import java.net.URI;

@Service
public class RestTemplateService {

    // getName() 메서드
    // http://localhost:9090/api/v1/crud-api에 GET 요청을 보내고, 서버에서 받은 응답의 본문을 반환함
    // GET 요청을 보내고, 응답의 본문을 가져오기 위해 RestTemplate 메서드인 getForEntity()가 사용되었음
    public String getName() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }

    // getNameWithPathVariable() 메서드
    // 경로 변수({name})가 포함된 http://localhost:9090/api/v1/crud-api/chaemin 에 GET 요청을 보내고, 서버에서 받은 응답의 본문을 변형함
    // 경로 변수를 포함한 GET 요청을 보내기 위해 RestTemplate 메서드와 getForEntity()가 사용되었음
    public String getNameWithPathVariable() {
        URI uri = UriComponentsBuilder // 여러 파라미터를 연결하여 URI 형식으로 만드는 기능을 수행함
                .fromUriString("http://localhost:9090") // 호출할 API URL 입력
                .path("/api/v1/crud-api/{name}") // 세부 경로 입력 - 여기에 사용된 변수와 같은 expand에서 지정
                .encode() //인코딩 문자셋 설정 (디폴트 값은 UTF-8)
                .build()
                .expand("chaemin") // expand() 안에는 {변수}에 넣을 값을 차례로 입력한다.
                // 복수의 값을 넣어야 할 경우 ,를 추가하여 구분한다~!
                .toUri(); // URI 타입으로 리턴 -> uri에 저장 -> 외부 API 요청하는데 사용됨

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class); // getForEntity(URI, 응답받는 타입)
        return responseEntity.getBody();
    }

    public String getNameWithParameter() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api/param")
                .queryParam("name", "chaemin")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }

    public ResponseEntity<MemberDto> postWithParamAndBody() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api")
                .queryParam("name", "chaemin")
                .queryParam("email", "chaeminyu@sookmyung.ac.kr")
                .queryParam("oraganization", "likelion")
                .encode()
                .build()
                .toUri();
        MemberDto memberDto = new MemberDto();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDto> responseEntity = restTemplate.postForEntity(
                uri, memberDto, MemberDto.class
        );
        return responseEntity;
    }

    public ResponseEntity<MemberDto> postWithHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api/add-header")
                .encode()
                .build()
                .toUri();

        MemberDto memberDto = new MemberDto();
        memberDto.setName("chaemin");
        memberDto.setEmail("chaeminyu@sookmyung.ac.kr");
        memberDto.setOrganization("likelion");

        RequestEntity<MemberDto> requestEntity = RequestEntity
                .post(uri)
                .header("my-header", "headertext")
                .body(memberDto);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDto> responseEntity = restTemplate.exchange(
                requestEntity, MemberDto.class
        );
        return responseEntity;
    }
}
