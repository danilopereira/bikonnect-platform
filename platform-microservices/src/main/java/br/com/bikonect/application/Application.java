package br.com.bikonect.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by danilopereira on 19/07/17.
 */
@SpringBootApplication
@ComponentScan({"br.com.bikonect.rider"})
@EnableJpaRepositories(basePackages = {"br.com.bikonect.dao"})
@EntityScan(basePackages = {"br.com.bikonect.entities"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
