package com.malibentoeventservice.malibentoeventservice.repository;

import com.malibentoeventservice.malibentoeventservice.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    Optional<Client> findByClientRef(final String clientRef);
}
