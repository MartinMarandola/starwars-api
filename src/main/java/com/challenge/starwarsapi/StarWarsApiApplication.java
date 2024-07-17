package com.challenge.starwarsapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableFeignClients
public class StarWarsApiApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load(); // Cargar variables de entorno desde .env
        SpringApplication app = new SpringApplication(StarWarsApiApplication.class);
        app.addInitializers((applicationContext) -> {
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            dotenv.entries().forEach(entry -> {
                environment.getSystemProperties().put(entry.getKey(), entry.getValue());
            });
        });
        app.run(args);
    }

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().load();
    }

}
