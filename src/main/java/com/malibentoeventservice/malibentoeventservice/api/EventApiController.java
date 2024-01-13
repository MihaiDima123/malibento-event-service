package com.malibentoeventservice.malibentoeventservice.api;

import com.malibentoeventservice.malibentoeventservice.dao.ApiResponse;
import com.malibentoeventservice.malibentoeventservice.dao.event.EventDTO;
import com.malibentoeventservice.malibentoeventservice.dao.event.EventListDTO;
import com.malibentoeventservice.malibentoeventservice.exceptions.api.MalibentoNotFoundException;
import com.malibentoeventservice.malibentoeventservice.service.EventService;
import com.malibentoeventservice.malibentoeventservice.session.HibernateSession;
import com.malibentoeventservice.malibentoeventservice.transformers.EventTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventApiController extends BaseApiController {
    private static final Logger logger = LoggerFactory.getLogger(EventApiController.class);
    private final EventService eventServiceImpl;

    @Autowired
    public EventApiController(final EventService eventServiceImpl,
                              final HibernateSession hibernateSession) {
        super(hibernateSession);
        this.eventServiceImpl = eventServiceImpl;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<EventListDTO>> getAllEvents() {
        return withCurrentTenant(() -> {
            try {
                final List<EventDTO> allEvents = eventServiceImpl.getAll().stream().map(EventTransformer::from).toList();

                return ResponseEntity.ok(
                        ApiResponse.<EventListDTO>empty()
                                .ofData(EventListDTO.ofEvents(allEvents))
                );
            } catch (Exception e) {
                logger.error("[getAllEvents]", e);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(ApiResponse.<EventListDTO>empty().ofError());
            }
        });
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<EventDTO>> getEventById(@PathVariable Integer id) {
        return withCurrentTenant(() -> {
            try {
                return ResponseEntity.ok(
                        ApiResponse.<EventDTO>empty()
                                .ofData(EventTransformer.from(eventServiceImpl.getEventById(id)))
                );
            } catch (final MalibentoNotFoundException e) {
                logger.error("[getEventById]", e);
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.<EventDTO>empty().ofError(e));
            } catch (final Throwable t) {
                logger.error("[getEventById]", t);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(ApiResponse.<EventDTO>empty().ofError());
            }
        });
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EventDTO>> createEvent(@RequestBody EventDTO eventDAO) {
        return withCurrentTenant(() -> {
            try {
                final var createdEvent = eventServiceImpl.createEvent(EventTransformer.from(eventDAO));

                return ResponseEntity.ok(
                        ApiResponse.<EventDTO>empty()
                                .ofData(EventTransformer.from(createdEvent))
                );
            } catch (final Throwable t) {
                logger.error("[createEvent]", t);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(ApiResponse.<EventDTO>empty().ofError());
            }
        });
    }

    @PatchMapping("{id}")
    public ResponseEntity<ApiResponse<EventDTO>> editEvent(@PathVariable Integer id,
                                                           @RequestBody EventDTO eventDAO) {
        return withCurrentTenant(() -> {
            try {
                final var updatedEvent = eventServiceImpl.editEvent(id, EventTransformer.from(eventDAO));

                return ResponseEntity.ok(
                        ApiResponse.<EventDTO>empty()
                                .ofData(EventTransformer.from(updatedEvent))
                );
            } catch (final Throwable t) {
                logger.error("[editEvent]", t);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(ApiResponse.<EventDTO>empty().ofError());
            }
        });
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<EventDTO>> deleteEvent(@PathVariable Integer id) {
        return withCurrentTenant(() -> {
            try {
                eventServiceImpl.removeEvent(id);
                return ResponseEntity.ok(
                        ApiResponse.empty()
                );
            } catch (final Throwable t) {
                logger.error("[editEvent]", t);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(ApiResponse.<EventDTO>empty().ofError());
            }
        });
    }
}
