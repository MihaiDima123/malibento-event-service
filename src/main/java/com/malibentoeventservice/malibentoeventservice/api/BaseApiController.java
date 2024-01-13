package com.malibentoeventservice.malibentoeventservice.api;

import com.malibentoeventservice.malibentoeventservice.session.HibernateSession;
import com.malibentoeventservice.malibentoeventservice.functional.AfterCallback;

public class BaseApiController {
    private final HibernateSession hibernateSession;

    public BaseApiController(final HibernateSession hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    protected <ReturnType> ReturnType withCurrentTenant(AfterCallback<ReturnType> callback) {
        hibernateSession.applySessionClientFilter();
        return callback.handle();
    }
}
