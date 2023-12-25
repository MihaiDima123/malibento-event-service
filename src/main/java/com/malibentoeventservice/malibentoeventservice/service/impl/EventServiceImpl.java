package com.malibentoeventservice.malibentoeventservice.service.impl;

import com.malibentoeventservice.malibentoeventservice.entities.Event;
import com.malibentoeventservice.malibentoeventservice.enums.Entities;
import com.malibentoeventservice.malibentoeventservice.exceptions.api.MalibentoNotFoundException;
import com.malibentoeventservice.malibentoeventservice.repository.EventRepository;
import com.malibentoeventservice.malibentoeventservice.service.ClientService;
import com.malibentoeventservice.malibentoeventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ClientService clientServiceImpl;

    @Autowired
    public EventServiceImpl(final EventRepository eventRepository,
                            final ClientService clientServiceImpl) {
        this.eventRepository = eventRepository;
        this.clientServiceImpl = clientServiceImpl;
    }

    @Override
    public Event getEventById(final Integer eventId) {
        return eventRepository
                .findByIdAndClient(eventId, clientServiceImpl.getCurrentClient())
                .orElseThrow(() -> new MalibentoNotFoundException(Entities.EVENT.getValue()));
    }

    @Override
    public Event createEvent(final Event event) {
        return eventRepository.save(
                event.setClient(clientServiceImpl.getCurrentClient())
        );
    }

    @Override
    public Event editEvent(final Integer id, final Event event) {
        return eventRepository.save(
                event.setId(id).setClient(clientServiceImpl.getCurrentClient())
        );
    }

    @Override
    public void removeEvent(final Integer eventId) {
        eventRepository.removeByIdAndClient(eventId, clientServiceImpl.getCurrentClient());
    }
}
