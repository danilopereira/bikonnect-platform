package br.com.bikonect.application;

import br.com.bikonect.configuration.MQTTSubscriberConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by danilopereira on 19/08/17.
 */
@SpringBootApplication(exclude = {
        EmbeddedServletContainerAutoConfiguration.class,
        WebMvcAutoConfiguration.class})
//@Import(MQTTSubscriberConfig.class)
@EnableAsync
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
