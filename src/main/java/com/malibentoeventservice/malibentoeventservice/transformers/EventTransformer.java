package com.malibentoeventservice.malibentoeventservice.transformers;

import com.malibentoeventservice.malibentoeventservice.dao.event.EventDTO;
import com.malibentoeventservice.malibentoeventservice.entities.Event;

public class EventTransformer {
    public static Event from(final EventDTO eventDTO) {
        final var event = new Event();
        event.setTitle(eventDTO.getTitle());
        event.setSubtitle(eventDTO.getSubtitle());
        event.setDescription(eventDTO.getDescription());
        event.setEventStartDate(eventDTO.getStartDate());
        event.setEventEndDate(eventDTO.getEndDate());
        event.setCreated(eventDTO.getCreated());
        event.setUpdated(eventDTO.getUpdated());
        event.setAuthorRef(eventDTO.getAuthorRef());

        return event;
    }

    public static EventDTO from(final Event event) {
        final var eventDTO =  EventDTO.empty()
                .ofTitle(event.getTitle())
                .ofSubtitle(event.getSubtitle())
                .ofDescription(event.getDescription())
                .ofStartDate(event.getEventStartDate())
                .ofEndDate(event.getEventEndDate())
                .ofCreated(event.getCreated())
                .ofUpdated(event.getUpdated());

        if (event.getLocation() != null) {
            eventDTO.setLocation(LocationTransformer.from(event.getLocation()));
        }

        return eventDTO;
    }
}
