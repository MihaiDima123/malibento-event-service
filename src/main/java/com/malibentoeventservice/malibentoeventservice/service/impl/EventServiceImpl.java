package com.malibentoeventservice.malibentoeventservice.service.impl;

import com.malibentoeventservice.malibentoeventservice.entities.Event;
import com.malibentoeventservice.malibentoeventservice.enums.Entities;
import com.malibentoeventservice.malibentoeventservice.exceptions.NoSuchClientException;
import com.malibentoeventservice.malibentoeventservice.exceptions.api.MalibentoNotFoundException;
import com.malibentoeventservice.malibentoeventservice.repository.EventRepository;
import com.malibentoeventservice.malibentoeventservice.service.ClientService;
import com.malibentoeventservice.malibentoeventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Event> getAll() throws NoSuchClientException {
        return eventRepository.findAllByClientId(
                clientServiceImpl.getCurrentClient().getId()
        );
    }

    @Override
    public Event getEventById(final Integer eventId) throws MalibentoNotFoundException, NoSuchClientException {
        return eventRepository
                .findByIdAndClient(eventId, clientServiceImpl.getCurrentClient().getId())
                .orElseThrow(() -> new MalibentoNotFoundException(Entities.EVENT.getValue()));
    }

    @Override
    public Event createEvent(final Event event) throws NoSuchClientException {
        return eventRepository.save(
                event.withClient(clientServiceImpl.getCurrentClient())
        );
    }

    @Override
    public Event editEvent(final Integer id, final Event event) throws NoSuchClientException {
        return eventRepository.save(
                event.withId(id).withClient(clientServiceImpl.getCurrentClient())
        );
    }

    @Override
    public void removeEvent(final Integer eventId) throws NoSuchClientException {
        eventRepository.removeByIdAndClient(eventId, clientServiceImpl.getCurrentClient().getId());
    }
}
