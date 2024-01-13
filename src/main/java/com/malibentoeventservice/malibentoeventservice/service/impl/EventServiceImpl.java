package com.malibentoeventservice.malibentoeventservice.service.impl;

import com.malibentoeventservice.malibentoeventservice.entities.Event;
import com.malibentoeventservice.malibentoeventservice.enums.Entities;
import com.malibentoeventservice.malibentoeventservice.exceptions.api.MalibentoNotFoundException;
import com.malibentoeventservice.malibentoeventservice.repository.EventRepository;
import com.malibentoeventservice.malibentoeventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll(){
        return eventRepository.findAllActive();
    }

    @Override
    public Event getEventById(final Integer eventId) throws MalibentoNotFoundException {
        return eventRepository
                .findByIdAndClient(eventId)
                .orElseThrow(() -> new MalibentoNotFoundException(Entities.EVENT.getValue()));
    }

    @Override
    public Event createEvent(final Event event) {
        return eventRepository.save(
                event
        );
    }

    @Override
    public Event editEvent(final Integer id, final Event event) {
        return eventRepository.save(event.withId(id));
    }

    @Override
    public void removeEvent(final Integer eventId) {
        eventRepository.removeByIdAndClient(eventId);
    }
}
