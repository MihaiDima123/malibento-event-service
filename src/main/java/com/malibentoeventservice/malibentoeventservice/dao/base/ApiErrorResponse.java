package com.malibentoeventservice.malibentoeventservice.dao.base;

import com.malibentoeventservice.malibentoeventservice.dao.ApiResponse;

public class ApiErrorResponse extends ApiResponse<Object, ApiErrorResponse> {
    public static ApiErrorResponse withError(final String errorMessage) {
        return new ApiErrorResponse().ofError(errorMessage);
    }

    public static ApiErrorResponse withError(final Throwable t) {
        return new ApiErrorResponse().ofError(t);
    }
}
