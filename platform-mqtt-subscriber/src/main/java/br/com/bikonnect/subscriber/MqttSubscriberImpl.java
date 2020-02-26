package br.com.bikonnect.subscriber;

import br.com.bikonnect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonnect.handler.MqttHandler;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/**
 * Created by danilopereira on 19/08/17.
 */
public class MqttSubscriberImpl implements MqttSubscriber {

    private String mqttBrokerUrl;
    private String topic;
    private LockerRepositoryService lockerRepositoryService;
    private String user;
    private String password;

    public MqttSubscriberImpl(String mqttBrokerUrl, String topic, LockerRepositoryService lockerRepositoryService,
                              String user, String password){
        this.mqttBrokerUrl = mqttBrokerUrl;
        this.topic = topic;
        this.lockerRepositoryService = lockerRepositoryService;
        this.user = user;
        this.password = password;

    }


    @Override
    public void consume(MqttHandler mqttHandler) throws Exception {
        MqttClient client=new MqttClient(mqttBrokerUrl, MqttClient.generateClientId());
        MqttConnectOptions connectOptions = new MqttConnectOptions();
        connectOptions.setUserName(user);
        connectOptions.setPassword(password.toCharArray());
        SimpleMqttCallBack simpleMqttCallBack = new SimpleMqttCallBack(mqttHandler);
        client.setCallback(simpleMqttCallBack );
        client.connect(connectOptions);
        client.subscribe(topic);
    }
}
