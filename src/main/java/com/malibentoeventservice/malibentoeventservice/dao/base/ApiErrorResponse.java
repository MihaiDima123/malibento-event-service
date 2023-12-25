package com.malibentoeventservice.malibentoeventservice.dao.base;

import com.malibentoeventservice.malibentoeventservice.dao.ApiResponse;

public class ApiErrorResponse extends ApiResponse<Object> {
    public static ApiResponse<Object> withError(final Throwable t) {
        return new ApiErrorResponse().ofError(t);
    }
}
