package com.malibentoeventservice.malibentoeventservice.advice;

import com.malibentoeventservice.malibentoeventservice.dao.base.ApiErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(AppExceptionControllerAdvice.class);

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<ApiErrorResponse> onAnyException(final Throwable t) {
        logger.error("[onAnyException] - {}", t.getMessage(), t);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiErrorResponse.withError(t));
    }
}
