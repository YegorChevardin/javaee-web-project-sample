package ua.com.yehorchevardin.andersen.javaee.project.sample.repository.configs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Class for configuring database
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
@PropertySource(value = "classpath:application.properties")
@Configuration
public class DatabaseConfigurations {
  private static final String TRANSACTION_ISOLATION_LEVEL = "TRANSACTION_READ_COMMITTED";

  @Bean
  public DataSource dataSource(HikariConfig config) {
    return new HikariDataSource(config);
  }

  @Bean
  public HikariConfig hikariConfig(
      @Value("${db.url}") String url,
      @Value("${db.user}") String username,
      @Value("${db.password}") String password,
      @Value("${db.driver}") String driverName,
      @Value("${db.connectionNumber}") int connectionNumber) {
    HikariConfig config = new HikariConfig();

    config.setUsername(username);
    config.setPassword(password);
    config.setJdbcUrl(url);
    config.setDriverClassName(driverName);
    config.setMaximumPoolSize(connectionNumber);

    config.setTransactionIsolation(TRANSACTION_ISOLATION_LEVEL);

    return config;
  }
}
