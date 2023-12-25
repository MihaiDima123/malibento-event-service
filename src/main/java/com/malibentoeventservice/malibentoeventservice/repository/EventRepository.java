package com.malibentoeventservice.malibentoeventservice.repository;

import com.malibentoeventservice.malibentoeventservice.entities.Client;
import com.malibentoeventservice.malibentoeventservice.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, Integer> {
    Optional<Event> findByIdAndClient(final Integer id, final Client client);

    @Query("update Event set deleted = true where id = :id and client = :client")
    void removeByIdAndClient(final Integer id, final Client client);
}
