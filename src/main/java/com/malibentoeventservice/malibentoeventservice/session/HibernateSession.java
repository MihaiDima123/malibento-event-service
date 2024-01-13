package com.malibentoeventservice.malibentoeventservice.session;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class HibernateSession {
    private final EntityManager entityManager;

    public HibernateSession(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void applySessionClientFilter() {
        final var session = entityManager.unwrap(Session.class);
        final var clientRefFilter = session.enableFilter("clientRefFilter");

        clientRefFilter.setParameter("clientRef", ThreadContext.retrieveCurrentClient());
    }
}
