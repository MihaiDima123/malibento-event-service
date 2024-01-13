package com.malibentoeventservice.malibentoeventservice.configuration.filters;

import com.malibentoeventservice.malibentoeventservice.session.ThreadContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
@Order(1)
public class BeforeAnyRequestFilter implements Filter {
    private static final String TENANT_REF_HEADER = "X-TENANT-ID";
    private static final Logger logger = LoggerFactory.getLogger(BeforeAnyRequestFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        var httpServletRequest = (HttpServletRequest) request;

        var tenantRef = httpServletRequest.getHeader(TENANT_REF_HEADER);

        if (!StringUtils.hasText(tenantRef)) {
            logger.warn("[doFilter] - tried to access api without a tenant header");
            throw new IllegalArgumentException("No header provided for tenant identity");
        }

        // Setting the current tenant in a thread local variable to be used later
        ThreadContext.setCurrentClient(tenantRef);

        chain.doFilter(request, response);
    }
}
