package com.malibentoeventservice.malibentoeventservice.service;

import com.malibentoeventservice.malibentoeventservice.entities.Client;

public interface ClientService {
    Client getClientByRef(final String clientRef);
    Client getCurrentClient();
}
