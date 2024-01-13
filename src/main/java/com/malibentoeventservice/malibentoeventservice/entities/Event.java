package com.malibentoeventservice.malibentoeventservice.entities;


import com.malibentoeventservice.malibentoeventservice.dao.event.EventDTO;
import com.malibentoeventservice.malibentoeventservice.transformers.EventTransformer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.time.LocalDateTime;

@FilterDef(
    name = "clientRefFilter",
    parameters = @ParamDef(name = "clientRef", type = String.class),
    defaultCondition = "client_ref = :clientRef"
)

@Getter
@Setter
@Entity
@Filter(name = "clientRefFilter", condition = "client_ref = :clientRef")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String subtitle;
    private String description;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;
    private String authorRef;
    private LocalDateTime created;
    private LocalDateTime updated;
    @ManyToOne
    private Visibility visibility;
    @ManyToOne
    private Location location;
    private String clientRef;

    private boolean active = true;
    private boolean deleted = false;

    @SuppressWarnings("unused")
    public EventDTO asDTO() {
        return EventTransformer.from(this);
    }

    public Event withId(final Integer id) {
        this.id = id;
        return this;
    }
}
