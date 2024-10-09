package com.wellcare.config_server_svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableConfigServer
@EnableWebSecurity
public class ConfigServerSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerSvcApplication.class, args);
	}

}
