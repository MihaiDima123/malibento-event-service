package com.malibentoeventservice.malibentoeventservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public final class ThreadContext {
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(ThreadContext.class);

    public static String retrieveCurrentClient() {
        final var currentTenantValue = currentTenant.get();
        if (!StringUtils.hasText(currentTenantValue)) {
            logger.warn("[retrieveCurrentClient] - invalid tenant name {}", currentTenantValue);
            throw new IllegalArgumentException("Invalid tenant ref");
        }

        return currentTenant.get();
    }

    public static void setCurrentClient(final String client) {
        currentTenant.set(client);
    }
}
