package br.com.bikonect.database.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

/**
 * Created by danilopereira on 20/07/17.
 */
@SpringBootApplication
public class FlywayMigrationApplication implements CommandLineRunner{

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy(){
        return new CustomFlywayMigrationStrategy();
    }

    public static void main(String[] args) {
        SpringApplication.run(FlywayMigrationApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Success!");
    }
}
