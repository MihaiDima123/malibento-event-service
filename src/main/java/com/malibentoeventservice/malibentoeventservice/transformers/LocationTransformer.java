package com.malibentoeventservice.malibentoeventservice.transformers;

import com.malibentoeventservice.malibentoeventservice.dao.location.LocationDTO;
import com.malibentoeventservice.malibentoeventservice.entities.Location;

public final class LocationTransformer {
    public static Location from(final LocationDTO locationDTO) {
        final var location = new Location();
        location.setName(locationDTO.getName());

        return location;
    }

    public static LocationDTO from(final Location location) {
        return LocationDTO.empty()
                .ofName(location.getName());
    }
}
