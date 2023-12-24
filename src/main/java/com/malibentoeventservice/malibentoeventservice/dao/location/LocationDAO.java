package com.malibentoeventservice.malibentoeventservice.dao.location;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDAO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static LocationDAO empty() {
        return new LocationDAO();
    }

    public LocationDAO ofName(final String name) {
        this.name = name;
        return this;
    }
}
