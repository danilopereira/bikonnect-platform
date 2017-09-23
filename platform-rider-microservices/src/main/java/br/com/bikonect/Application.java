package br.com.bikonect;

import br.com.bikonect.config.DaoConfig;
import br.com.bikonect.config.RiderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by danilopereira on 19/07/17.
 */
@SpringBootApplication
@ComponentScan({"br.com.bikonect.rider"})
@Import({RiderConfig.class, DaoConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
