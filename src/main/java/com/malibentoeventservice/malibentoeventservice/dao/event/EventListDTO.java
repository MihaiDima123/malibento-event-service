package com.malibentoeventservice.malibentoeventservice.dao.event;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EventListDTO {
    private List<EventDTO> events = new ArrayList<>();

    public static EventListDTO ofEvents(List<EventDTO> eventDTOS) {
        final var eventList = new EventListDTO();
        eventList.events = eventDTOS;

        return eventList;
    }
}
