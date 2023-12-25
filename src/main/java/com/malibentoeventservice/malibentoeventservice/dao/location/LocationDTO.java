package com.malibentoeventservice.malibentoeventservice.dao.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.malibentoeventservice.malibentoeventservice.entities.Location;
import com.malibentoeventservice.malibentoeventservice.transformers.LocationTransformer;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static LocationDTO empty() {
        return new LocationDTO();
    }

    public LocationDTO ofName( final String name) {
        this.name = name;
        return this;
    }

    public Location asEntity() {
        return LocationTransformer.from(this);
    }
}
