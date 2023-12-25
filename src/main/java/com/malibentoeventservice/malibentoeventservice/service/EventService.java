package com.malibentoeventservice.malibentoeventservice.service;

import com.malibentoeventservice.malibentoeventservice.entities.Event;

public interface EventService {
    Event getEventById(final Integer eventId);
    Event createEvent(final Event event);
    Event editEvent(final Event event);
    void removeEvent(final Integer eventId);
}
