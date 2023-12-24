package com.malibentoeventservice.malibentoeventservice.configuration;

import com.malibentoeventservice.malibentoeventservice.configuration.filters.BeforeAnyRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistrationConfiguration {
    private static final String ON_ANY_REQUEST_FILTER_PATTERN = "/api/*";

    @Bean
    public FilterRegistrationBean<BeforeAnyRequestFilter> onAnyRequestFilterRegistration(BeforeAnyRequestFilter beforeAnyRequestFilter) {
        var registrationBean = new FilterRegistrationBean<BeforeAnyRequestFilter>();

        registrationBean.setFilter(beforeAnyRequestFilter);
        registrationBean.addUrlPatterns(ON_ANY_REQUEST_FILTER_PATTERN);

        return registrationBean;
    }
}
