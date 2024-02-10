package com.malibentoeventservice.malibentoeventservice.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatasourceConfiguration {
    private final String connectionUrl;
    private final String connectionUser;
    private final String connectionPassword;
    private final String driverClassname;
    private final Integer leakDetectionThreshold;
    private final Integer maximumPoolSize;
    private final Integer maximumIdle;

    public DatasourceConfiguration(
            @Value("${app.datasource.url}") String connectionUrl,
            @Value("${app.datasource.user}") String connectionUser,
            @Value("${app.datasource.password}") String connectionPassword,
            @Value("${app.datasource.driver-classname}") String driverClassname,
            @Value("${app.datasource.leak-detection-threshold}") Integer leakDetectionThreshold,
            @Value("${app.datasource.maximum-pool-size}") Integer maximumPoolSize,
            @Value("${app.datasource.maximum-idle}") Integer maximumIdle) {
        this.connectionUrl = connectionUrl;
        this.connectionUser = connectionUser;
        this.connectionPassword = connectionPassword;
        this.driverClassname = driverClassname;
        this.leakDetectionThreshold = leakDetectionThreshold;
        this.maximumPoolSize = maximumPoolSize;
        this.maximumIdle = maximumIdle;
    }

    @Bean
    public DataSource dataSource() {
        var datasource = new HikariDataSource();
        datasource.setUsername(connectionUser);
        datasource.setPassword(connectionPassword);
        datasource.setJdbcUrl(connectionUrl);
        datasource.setDriverClassName(driverClassname);

        datasource.setLeakDetectionThreshold(leakDetectionThreshold);
        datasource.setMaximumPoolSize(maximumPoolSize);
        datasource.setMinimumIdle(maximumIdle);

        return datasource;
    }
}
