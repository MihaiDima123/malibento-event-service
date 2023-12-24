package com.malibentoeventservice.malibentoeventservice.api;

import com.malibentoeventservice.malibentoeventservice.dao.event.ApiEventResponse;
import com.malibentoeventservice.malibentoeventservice.dao.event.EventDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/events")
public class EventApiController {
    @GetMapping("{id}")
    public ResponseEntity<ApiEventResponse> getEventById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiEventResponse
                        .empty()
                        .ofData(EventDAO.empty())
        );
    }

    @PostMapping
    public ResponseEntity<ApiEventResponse> createEvent(@RequestBody EventDAO eventDAO) {
        return ResponseEntity.ok(
                ApiEventResponse.empty()
                        .ofData(eventDAO)
        );
    }

    @PatchMapping
    public ResponseEntity<ApiEventResponse> editEvent(@RequestBody EventDAO eventDAO) {
        return ResponseEntity.ok(
                ApiEventResponse.empty()
                        .ofData(eventDAO)
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiEventResponse> deleteEvent(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiEventResponse.empty()
        );
    }
}
