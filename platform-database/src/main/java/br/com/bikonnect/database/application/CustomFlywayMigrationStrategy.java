package br.com.bikonnect.database.application;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

/**
 * Created by danilopereira on 24/07/17.
 */
public class CustomFlywayMigrationStrategy implements FlywayMigrationStrategy {
    @Override
    public void migrate(Flyway flyway) {
        System.out.println(flyway.isOutOfOrder());
        flyway.repair();
        flyway.migrate();
    }
}
