package com.malibentoeventservice.malibentoeventservice.repository;

import com.malibentoeventservice.malibentoeventservice.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, Integer> {
    @Query("select e " +
            "from Event e " +
            "where e.client.id = :clientId and e.active = true and e.deleted = false")
    List<Event> findAllByClientId(final Integer clientId);

    @Query("select e " +
            "from Event e " +
            "where e.id = :id and e.client.id = :clientId and e.active = true and e.deleted = false")
    Optional<Event> findByIdAndClient(final Integer id, final Integer clientId);

    @Query("update Event " +
            "set deleted = true " +
            "where id = :id and client.id = :clientId")
    void removeByIdAndClient(final Integer id, final Integer clientId);
}
