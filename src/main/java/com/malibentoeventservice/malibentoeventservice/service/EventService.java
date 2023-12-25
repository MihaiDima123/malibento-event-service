package com.malibentoeventservice.malibentoeventservice.service;

import com.malibentoeventservice.malibentoeventservice.entities.Event;
import com.malibentoeventservice.malibentoeventservice.exceptions.NoSuchClientException;
import com.malibentoeventservice.malibentoeventservice.exceptions.api.MalibentoNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface EventService {
    Event getEventById(final Integer eventId) throws MalibentoNotFoundException, NoSuchClientException;
    @Transactional
    Event createEvent(final Event event) throws NoSuchClientException;
    @Transactional
    Event editEvent(final Integer id, final Event event) throws NoSuchClientException;
    @Transactional
    void removeEvent(final Integer eventId) throws NoSuchClientException;
}
