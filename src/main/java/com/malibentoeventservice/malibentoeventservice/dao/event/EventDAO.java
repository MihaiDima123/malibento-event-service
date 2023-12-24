package com.malibentoeventservice.malibentoeventservice.dao.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.malibentoeventservice.malibentoeventservice.dao.location.LocationDAO;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDAO {
    private String title;
    private String subtitle;
    private String description;
    @JsonProperty("start_date")
    private LocalDateTime startDate;
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    private LocalDateTime created;
    private LocalDateTime updated;
    private LocationDAO location;

    public static EventDAO empty() {
        return new EventDAO();
    }

    public EventDAO ofTitle(final String title) {
        this.title = title;
        return this;
    }

    public EventDAO ofSubtitle(final String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public EventDAO ofDescription(final String description) {
        this.description = description;
        return this;
    }

    public EventDAO ofStartDate(final LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventDAO ofEndDate(final LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventDAO ofCreated(final LocalDateTime created) {
        this.created = created;
        return this;
    }

    public EventDAO ofUpdated(final LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

    public EventDAO ofLocation(final LocationDAO location) {
        this.location = location;
        return this;
    }
}
