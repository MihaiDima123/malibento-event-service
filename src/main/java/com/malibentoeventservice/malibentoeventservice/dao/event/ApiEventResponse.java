package com.malibentoeventservice.malibentoeventservice.dao.event;

import com.malibentoeventservice.malibentoeventservice.dao.base.ApiResponse;

public class ApiEventResponse extends ApiResponse<EventDAO, ApiEventResponse> {
    public static ApiEventResponse empty() {
        return new ApiEventResponse();
    }
}
