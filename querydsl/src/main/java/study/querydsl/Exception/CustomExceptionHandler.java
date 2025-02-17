package study.querydsl.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleException(RuntimeException e, HttpServletRequest request){
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        LOGGER.error("Advice 내 handleException 호출, {}, {}", request.getRequestURI(), e.getMessage());
        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    // CustomException을 처리하는 핸들러
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Map<String, String>> handleException(CustomException e, HttpServletRequest request) {
        LOGGER.error("Advice 내 handleException 호출, URI: {}, 메세지: {}", request.getRequestURI(), e.getMessage());

        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatus().getMessage()); // HttpStatus의 설명
        map.put("code", Integer.toString(e.getHttpStatus().getCode())); // HttpStatus 코드
        map.put("message", e.getMessage()); // 예외 메세지

        return ResponseEntity
                .status(e.getHttpStatus().getCode())
                .body(map);
    }
}
