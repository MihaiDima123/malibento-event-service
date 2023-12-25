package com.malibentoeventservice.malibentoeventservice.service;

import com.malibentoeventservice.malibentoeventservice.entities.Event;
import org.springframework.transaction.annotation.Transactional;

public interface EventService {
    Event getEventById(final Integer eventId);
    @Transactional
    Event createEvent(final Event event);
    @Transactional
    Event editEvent(final Event event);
    @Transactional
    void removeEvent(final Integer eventId);
}
