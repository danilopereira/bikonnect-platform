package br.com.bikonect.locker;

import br.com.bikonect.locker.config.DaoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by danilopereira on 12/09/17.
 */
@SpringBootApplication
@ComponentScan({"br.com.bikonect.locker"})
@Import({DaoConfig.class})
public class Application {
    public static void main (String [] args){
        SpringApplication.run(Application.class);
    }

}
