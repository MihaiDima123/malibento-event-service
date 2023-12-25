package com.malibentoeventservice.malibentoeventservice.dao.event;

import com.malibentoeventservice.malibentoeventservice.dao.ApiResponse;

public class ApiEventResponse extends ApiResponse<EventDTO, ApiEventResponse> {
    public static ApiEventResponse empty() {
        return new ApiEventResponse();
    }
}
