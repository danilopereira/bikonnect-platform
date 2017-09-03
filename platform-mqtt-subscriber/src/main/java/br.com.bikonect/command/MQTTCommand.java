package br.com.bikonect.command;

import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonect.subscriber.MqttSubscriber;
import br.com.bikonect.subscriber.SimpleMqttCallBack;
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
    @Value("${mqtt.topic}")
    protected String topic;

    @Value("${mqtt.broker.url}")
    protected String mqttBrokerUrl;

    @Autowired
    protected ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    protected LockerRepositoryService lockerRepositoryService;

    @Autowired
    protected MqttSubscriber subscriber;

    Logger log = LoggerFactory.getLogger(MQTTCommand.class);

    @Override
    public void run(String... strings) throws Exception {
        String message = subscriber.consume();
        while(true){
            if(null == message){
                Thread.sleep(2000);
                continue;
            }
            else{
                MQTTTask task = new MQTTTask(message, lockerRepositoryService);
                taskExecutor.execute(task);
            }
        }

    }
}
