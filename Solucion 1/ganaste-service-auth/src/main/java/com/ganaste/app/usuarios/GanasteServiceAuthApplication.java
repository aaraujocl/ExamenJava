package com.ganaste.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class GanasteServiceAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GanasteServiceAuthApplication.class, args);
	}

}
