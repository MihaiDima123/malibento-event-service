package com.malibentoeventservice.malibentoeventservice.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.malibentoeventservice.malibentoeventservice.dao.base.ErrorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T, REF extends ApiResponse<T, ?>> {
    private T data;
    private List<ErrorDTO> errors;

    public static <T, REF extends ApiResponse<T, REF>> ApiResponse<T, REF> empty() {
        return new ApiResponse<T, REF>();
    }

    public REF ofError(final String errorMessage) {
        return addErrorForListAndReturnSelf(errorMessage);
    }

    public REF ofError(final Throwable t) {
        return addErrorForListAndReturnSelf(t.getMessage());
    }

    public REF ofData(final T data) {
        this.data = data;
        return self();
    }

    @SuppressWarnings("unchecked")
    public REF self() {
        return (REF) this;
    }

    private void addErrorForList(final String errorMessage) {
        if (Objects.isNull(errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(ErrorDTO.from(errorMessage));
    }

    private REF addErrorForListAndReturnSelf(final String errorMessage) {
        addErrorForList(errorMessage);
        return self();
    }
}
