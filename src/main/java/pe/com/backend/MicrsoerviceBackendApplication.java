package pe.com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class MicrsoerviceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrsoerviceBackendApplication.class, args);
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		String url = "";
		
		String server = "fisidatabase.ctzjuhvvq7q5.us-east-1.rds.amazonaws.com";
		String database = "fisi";
		url = "jdbc:mysql://"+server+":3306/"+database;
		String user = "admin";
		String password = "fisidatabase";
		
		datasource.setUsername(user);
		datasource.setPassword(password);
				
		datasource.setUrl(url);
		
		return datasource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplateMySql() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
}
