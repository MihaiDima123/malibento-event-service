package com.malibentoeventservice.malibentoeventservice.service;

import com.malibentoeventservice.malibentoeventservice.dao.event.EventDAO;

public interface EventService {
    EventDAO getEventById(final Integer eventId);
    EventDAO createEvent(final EventDAO eventDAO);
    EventDAO editEvent(final EventDAO eventDAO);
    void removeEvent(final Integer eventId);
}
