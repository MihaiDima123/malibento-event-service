package com.malibentoeventservice.malibentoeventservice.dao.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.malibentoeventservice.malibentoeventservice.dao.location.LocationDTO;
import com.malibentoeventservice.malibentoeventservice.entities.Event;
import com.malibentoeventservice.malibentoeventservice.transformers.EventTransformer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDTO {
    private String title;
    private String subtitle;
    private String description;
    private String authorRef;
    @JsonProperty("start_date")
    private LocalDateTime startDate;
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    private LocalDateTime created;
    private LocalDateTime updated;
    private LocationDTO location;

    public static EventDTO empty() {
        return new EventDTO();
    }

    public EventDTO ofTitle(final String title) {
        this.title = title;
        return this;
    }

    public EventDTO ofSubtitle(final String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public EventDTO ofDescription(final String description) {
        this.description = description;
        return this;
    }

    public EventDTO ofStartDate(final LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventDTO ofEndDate(final LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventDTO ofCreated(final LocalDateTime created) {
        this.created = created;
        return this;
    }

    public EventDTO ofUpdated(final LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

    public EventDTO ofLocation(final LocationDTO location) {
        this.location = location;
        return this;
    }

    @SuppressWarnings("unused")
    public Event asEntity() {
        return EventTransformer.from(this);
    }
}
