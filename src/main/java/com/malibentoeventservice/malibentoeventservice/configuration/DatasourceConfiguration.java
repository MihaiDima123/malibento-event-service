package com.malibentoeventservice.malibentoeventservice.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {
    private final String connectionUrl;
    private final String connectionUser;
    private final String connectionPassword;
    private final String driverClassname;

    public DatasourceConfiguration(
            @Value("${app.datasource.url}") String connectionUrl,
            @Value("${app.datasource.user}") String connectionUser,
            @Value("${app.datasource.password}") String connectionPassword,
            @Value("${app.datasource.driverClassname}") String driverClassname) {
        this.connectionUrl = connectionUrl;
        this.connectionUser = connectionUser;
        this.connectionPassword = connectionPassword;
        this.driverClassname = driverClassname;
    }

    @Bean
    public DataSource dataSource() {
        var datasource = new HikariDataSource();
        datasource.setUsername(connectionUser);
        datasource.setPassword(connectionPassword);
        datasource.setJdbcUrl(connectionUrl);
        datasource.setDriverClassName(driverClassname);

        datasource.setLeakDetectionThreshold(120_000);
        datasource.setMaximumPoolSize(10);
        datasource.setMinimumIdle(2);

        return datasource;
    }
}
