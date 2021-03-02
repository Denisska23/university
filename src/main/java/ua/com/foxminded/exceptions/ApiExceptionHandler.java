package ua.com.foxminded.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiExceptionData> handleNotFoundException(NotFoundException e) {
        return defaultErrorResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotModifiedException.class)
    public ResponseEntity<ApiExceptionData> handleNotFoundException(NotModifiedException e) {
        return defaultErrorResponse(e, HttpStatus.NOT_MODIFIED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionData> handleNotValidateException(MethodArgumentNotValidException e) {
        ApiExceptionData apiExceptionData = new ApiExceptionData("Validation error",
                LocalDateTime.now(),
                e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(apiExceptionData, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ApiExceptionData> defaultErrorResponse(Exception exception, HttpStatus httpStatus) {
        log.error("[ERROR] -> ", exception);
        ApiExceptionData apiExceptionData = new ApiExceptionData(exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiExceptionData, httpStatus);
    }
}
