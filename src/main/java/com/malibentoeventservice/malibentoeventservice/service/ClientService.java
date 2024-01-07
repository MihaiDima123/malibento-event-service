package com.malibentoeventservice.malibentoeventservice.service;

import com.malibentoeventservice.malibentoeventservice.entities.Client;
import com.malibentoeventservice.malibentoeventservice.exceptions.NoSuchClientException;

public interface ClientService {
    Client getClientByRef(final String clientRef) throws NoSuchClientException;
    Client getCurrentClient() throws NoSuchClientException;
}
