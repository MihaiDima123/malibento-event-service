package com.malibentoeventservice.malibentoeventservice.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.malibentoeventservice.malibentoeventservice.dao.base.ErrorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private static final String DEFAULT_API_ERROR = "Server error";
    private boolean success = true;
    private T data;
    private List<ErrorDTO> errors;

    public static <T> ApiResponse<T> empty() {
        return new ApiResponse<>();
    }

    public ApiResponse<T> ofError(Throwable t) {
        setSuccess(false);
        return addErrorForListAndReturnSelf(t.getMessage());
    }

    public ApiResponse<T> ofError() {
        setSuccess(false);
        return addErrorForListAndReturnSelf(DEFAULT_API_ERROR);
    }

    public ApiResponse<T> ofData(T data) {
        this.data = data;
        return this;
    }

    private void addErrorForList(String errorMessage) {
        if (Objects.isNull(errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(ErrorDTO.from(errorMessage));
    }

    private ApiResponse<T> addErrorForListAndReturnSelf(String errorMessage) {
        addErrorForList(errorMessage);
        return this;
    }

    @SuppressWarnings(value = "unused")
    public T getData() {
        return data;
    }

    @SuppressWarnings(value = "unused")
    public List<ErrorDTO> getErrors() {
        return errors;
    }

    @SuppressWarnings("unused")
    public boolean isSuccess() {
        return success;
    }

    @SuppressWarnings("unused")
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
