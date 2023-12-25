package com.malibentoeventservice.malibentoeventservice.service.impl;

import com.malibentoeventservice.malibentoeventservice.configuration.ThreadContext;
import com.malibentoeventservice.malibentoeventservice.entities.Client;
import com.malibentoeventservice.malibentoeventservice.exceptions.NoSuchClientException;
import com.malibentoeventservice.malibentoeventservice.repository.ClientRepository;
import com.malibentoeventservice.malibentoeventservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientByRef(final String clientRef) {
        final var optionalClientByRef = clientRepository.findByClientRef(clientRef);

        if (optionalClientByRef.isEmpty()) {
            throw new NoSuchClientException();
        }

        return optionalClientByRef.get();
    }

    @Override
    public Client getCurrentClient() {
        return getClientByRef(ThreadContext.retrieveCurrentClient());
    }
}
