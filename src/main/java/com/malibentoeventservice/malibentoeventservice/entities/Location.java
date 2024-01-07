package com.malibentoeventservice.malibentoeventservice.entities;

import com.malibentoeventservice.malibentoeventservice.dao.location.LocationDTO;
import com.malibentoeventservice.malibentoeventservice.transformers.LocationTransformer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String position; // TODO: Change this thing XD. Maybe a locator service i don't know how that works (yet)

    @SuppressWarnings("unused")
    public LocationDTO asDTO() {
        return LocationTransformer.from(this);
    }
}
