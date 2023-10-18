package com.example.numberofrepeatedcharsinstring.exceptionHandler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Глобальный перехватчик исключений, предназначенный для обработки исключений в контроллерах.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Обрабатывает исключения типа ConstraintViolationException
     * и возвращает ответ с сообщением об ошибке и статусом "BAD REQUEST" (HTTP 400).
     *
     * @param ex Исключение типа ConstraintViolationException, содержащее сообщение об ошибке.
     * @return ResponseEntity с сообщением об ошибке и статусом "BAD REQUEST".
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> argumentException(ConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST) ;
    }
}

