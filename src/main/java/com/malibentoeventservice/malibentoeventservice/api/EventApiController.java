package com.malibentoeventservice.malibentoeventservice.api;

import com.malibentoeventservice.malibentoeventservice.dao.event.ApiEventResponse;
import com.malibentoeventservice.malibentoeventservice.dao.event.EventDTO;
import com.malibentoeventservice.malibentoeventservice.service.EventService;
import com.malibentoeventservice.malibentoeventservice.transformers.EventTransformer;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final EventService eventServiceImpl;

    @Autowired
    public EventApiController(final EventService eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiEventResponse> getEventById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiEventResponse
                        .empty()
                        .ofData(EventTransformer.from(eventServiceImpl.getEventById(id)))
        );
    }

    @PostMapping
    public ResponseEntity<ApiEventResponse> createEvent(@RequestBody EventDTO eventDAO) {
        final var createdEvent = eventServiceImpl.createEvent(EventTransformer.from(eventDAO));

        return ResponseEntity.ok(
                ApiEventResponse.empty()
                        .ofData(EventTransformer.from(createdEvent))
        );
    }

    @PatchMapping("{id}")
    public ResponseEntity<ApiEventResponse> editEvent(@PathVariable Integer id,
                                                      @RequestBody EventDTO eventDAO) {
        final var updatedEvent = eventServiceImpl.editEvent(id, EventTransformer.from(eventDAO));

        return ResponseEntity.ok(
                ApiEventResponse.empty()
                        .ofData(EventTransformer.from(updatedEvent))
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiEventResponse> deleteEvent(@PathVariable Integer id) {
        eventServiceImpl.removeEvent(id);
        return ResponseEntity.ok(
                ApiEventResponse.empty()
        );
    }
}
