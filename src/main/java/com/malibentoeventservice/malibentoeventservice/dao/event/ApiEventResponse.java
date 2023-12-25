package com.malibentoeventservice.malibentoeventservice.dao.event;

import com.malibentoeventservice.malibentoeventservice.dao.ApiResponse;

public class ApiEventResponse extends ApiResponse<EventDTO> {
    public static ApiEventResponse empty() {
        return new ApiEventResponse();
    }
}
