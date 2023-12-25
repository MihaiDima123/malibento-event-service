package com.malibentoeventservice.malibentoeventservice.advice;

import com.malibentoeventservice.malibentoeventservice.configuration.ThreadContext;
import com.malibentoeventservice.malibentoeventservice.dao.base.ApiErrorResponse;
import com.malibentoeventservice.malibentoeventservice.exceptions.NoSuchClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(AppExceptionControllerAdvice.class);
    private static final String ERROR_MESSAGE = "Unexpected error";

    @ExceptionHandler(value = {Throwable.class})
    public ApiErrorResponse onAnyException(final Throwable t) {
        logger.error("[onAnyException] - {}", t.getMessage(), t);
        return ApiErrorResponse.withError(ERROR_MESSAGE);
    }

    @ExceptionHandler(value = {NoSuchClientException.class})
    public ApiErrorResponse onClientNotFound(final Throwable t) {
        logger.warn("[onClientNotFound] - client could not be found {}", ThreadContext.retrieveCurrentClient(), t);
        return ApiErrorResponse.withError(t);
    }
}
