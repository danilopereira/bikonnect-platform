package br.com.bikonnect.application;

import br.com.bikonnect.configuration.MQTTSubscriberConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by danilopereira on 19/08/17.
 */
@SpringBootApplication(exclude = {
        EmbeddedServletContainerAutoConfiguration.class,
        WebMvcAutoConfiguration.class})
@Import(value=MQTTSubscriberConfig.class)
@ComponentScan(value = {"br.com.bikonnect.command"})
public class Application {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
