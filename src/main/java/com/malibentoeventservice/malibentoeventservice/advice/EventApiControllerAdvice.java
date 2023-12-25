package com.malibentoeventservice.malibentoeventservice.advice;

import com.malibentoeventservice.malibentoeventservice.dao.base.ApiErrorResponse;
import com.malibentoeventservice.malibentoeventservice.exceptions.api.MalibentoNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EventApiControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(EventApiControllerAdvice.class);

    @ExceptionHandler(value = {MalibentoNotFoundException.class})
    public ApiErrorResponse onEntityNotFound(final Throwable t) {
        logger.warn("[onEntityNotFound] - {}", t.getMessage(), t);
        return ApiErrorResponse.withError(t);
    }
}
