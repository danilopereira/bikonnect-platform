package br.com.bikonect.command;

import br.com.bikonect.subscriber.MqttSubscriber;
import br.com.bikonect.task.MQTTTask;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * Created by danilopereira on 26/08/17.
 */
@Component
public class MQTTCommand implements CommandLineRunner {
    @Autowired
    private MqttSubscriber subscriber;

    @Value("${mqtt.topic}")
    private String topic;

    @Autowired
    protected ThreadPoolTaskExecutor taskExecutor;

    private static final Logger log = LoggerFactory.getLogger(MQTTCommand.class);

    @Override
    public void run(String... strings) throws Exception {
        log.info("Application Started here!");
        System.out.println("PASSEI AQUI!!");
        while(true){
            MqttClient client = subscriber.consume();
            if(client == null){
                Thread.sleep(2000);
                continue;
            }
            else{
                MQTTTask task = new MQTTTask(client, topic);
                taskExecutor.execute(task);
            }
        }

    }
}
