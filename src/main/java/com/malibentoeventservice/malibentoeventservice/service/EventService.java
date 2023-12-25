package com.malibentoeventservice.malibentoeventservice.service;

import com.malibentoeventservice.malibentoeventservice.dao.event.EventDTO;

public interface EventService {
    EventDTO getEventById(final Integer eventId);
    EventDTO createEvent(final EventDTO eventDAO);
    EventDTO editEvent(final EventDTO eventDAO);
    void removeEvent(final Integer eventId);
}
