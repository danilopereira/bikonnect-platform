package br.com.bikonnect.command;

import br.com.bikonnect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonnect.handler.MqttHandler;
import br.com.bikonnect.subscriber.MqttSubscriber;
import br.com.bikonnect.task.MqttTask;
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
    protected MqttSubscriber subscriber;

    @Autowired
    protected MqttHandler mqttHandler;

    @Autowired
    protected LockerRepositoryService lockerRepositoryService;

    @Autowired
    protected ThreadPoolTaskExecutor taskExecutor;

    Logger log = LoggerFactory.getLogger(MQTTCommand.class);

    @Override
    public void run(String... strings) throws Exception {
        subscriber.consume(mqttHandler);
        while (true){
            if(null == mqttHandler.getMessage()){
                Thread.sleep(2000);
            }
            else{
                MqttTask task =  new MqttTask(mqttHandler.getMessage(), lockerRepositoryService);
                taskExecutor.execute(task);
                mqttHandler.setMessage(null);
            }
        }
    }
}
