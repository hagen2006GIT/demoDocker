package edu.example.demoDocker.exception;

import edu.example.demoDocker.models.response.ResponseBodyForException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllControllerAdvice {
    @ExceptionHandler(Step2Exception.class)
    public ResponseEntity<String> exceptionStep2Exception(Step2Exception e) {
        return ResponseEntity.badRequest().body(e.toString());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseBodyForException validationErrorHandler(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        String str="Ошибка получения обязательного параметра. Отсутствует <FIELD NAME> или не заполнено его значение";
        assert fieldError != null;
        str=str.replace("FIELD NAME",fieldError.getField());
        return new ResponseBodyForException(str,e.toString(),e.getStackTrace());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus
    public ResponseEntity<String> handleException(Exception e) {
        var httpStatus = switch (e.getClass().getSimpleName()) {
            case ("NoSuchElementException") -> HttpStatus.NOT_FOUND;
            case ("DuplicateKeyException"), ("NullPointerException") -> HttpStatus.BAD_REQUEST;
            default -> throw new IllegalStateException("Unexpected value: " + e.getClass().getSimpleName());
        };
        return new ResponseEntity<>(e.toString(),httpStatus);
    }
}
