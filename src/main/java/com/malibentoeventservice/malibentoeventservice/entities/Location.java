package com.malibentoeventservice.malibentoeventservice.entities;

import com.malibentoeventservice.malibentoeventservice.dao.location.LocationDTO;
import com.malibentoeventservice.malibentoeventservice.transformers.LocationTransformer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String position; // TODO: Change this thing XD. Maybe a locator service i don't know how that works (yet)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocationDTO asDTO() {
        return LocationTransformer.from(this);
    }
}
