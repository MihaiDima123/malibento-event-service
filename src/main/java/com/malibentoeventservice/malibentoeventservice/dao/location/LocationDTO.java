package com.malibentoeventservice.malibentoeventservice.dao.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.malibentoeventservice.malibentoeventservice.entities.Location;
import com.malibentoeventservice.malibentoeventservice.transformers.LocationTransformer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDTO {
    private String name;

    public static LocationDTO empty() {
        return new LocationDTO();
    }

    public LocationDTO ofName(String name) {
        this.name = name;
        return this;
    }

    @SuppressWarnings("unused")
    public Location asEntity() {
        return LocationTransformer.from(this);
    }
}
