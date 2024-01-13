package com.malibentoeventservice.malibentoeventservice.repository;

import com.malibentoeventservice.malibentoeventservice.entities.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, Integer> {
    @Query("select e " +
            "from Event e " +
            "where e.active = true and e.deleted = false")
    List<Event> findAllActive();

    @Query("select e " +
            "from Event e " +
            "where e.id = :id and e.active = true and e.deleted = false")
    Optional<Event> findByIdAndClient(final Integer id);

    @Modifying
    @Query("update Event " +
            "set deleted = true " +
            "where id = :id")
    void removeByIdAndClient(final Integer id);
}
