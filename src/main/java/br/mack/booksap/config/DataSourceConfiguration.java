package br.mack.booksap.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

	@Value("${spring.datasource.url}")
	String url;

	@Value("${spring.datasource.username}")
	String username;

	@Value("${spring.datasource.password}")
	String password;

	@Value("${spring.datasource.driver-class-name}")
	String driver;

	@Bean
	DataSource hikariDataSource() {
		HikariConfig config = new HikariConfig();
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setMaximumPoolSize(10); // num máximo de conns
		config.setMinimumIdle(1); // num inicial de conns
		config.setPoolName("books-db-pool");
		config.setMaxLifetime(600000); // 10 minutos em ms
		config.setConnectionTimeout(10000);
		config.setConnectionTestQuery("SELECT 1"); // apenas um teste com o banco
		return new HikariDataSource(config);
	}

}
