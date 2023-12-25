package com.malibentoeventservice.malibentoeventservice.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.malibentoeventservice.malibentoeventservice.dao.base.ErrorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private static final String DEFAULT_API_ERROR = "Server error";

    private T data;
    private List<ErrorDTO> errors;

    public static <T> ApiResponse<T> empty() {
        return new ApiResponse<>();
    }

    public ApiResponse<T> ofError(final Throwable t) {
        return addErrorForListAndReturnSelf(t.getMessage());
    }

    public ApiResponse<T> ofError() {
        return addErrorForListAndReturnSelf(DEFAULT_API_ERROR);
    }

    public ApiResponse<T> ofData(final T data) {
        this.data = data;
        return this;
    }

    private void addErrorForList(final String errorMessage) {
        if (Objects.isNull(errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(ErrorDTO.from(errorMessage));
    }

    private ApiResponse<T> addErrorForListAndReturnSelf(final String errorMessage) {
        addErrorForList(errorMessage);
        return this;
    }

    public T getData() {
        return data;
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }
}
