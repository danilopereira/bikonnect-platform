package br.com.bikonect.command;

import br.com.bikonect.subscriber.MqttSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by danilopereira on 26/08/17.
 */
@Component
public class MQTTCommand implements CommandLineRunner {
    @Value("${mqtt.topic}")
    protected String topic;

    @Value("${mqtt.broker.url}")
    protected String mqttBrokerUrl;

    @Autowired
    protected MqttSubscriber subscriber;

    Logger log = LoggerFactory.getLogger(MQTTCommand.class);

    @Override
    public void run(String... strings) throws Exception {
        subscriber.consume();
    }
}
