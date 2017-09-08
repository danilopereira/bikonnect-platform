package br.com.bikonect.subscriber;

import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import org.eclipse.paho.client.mqttv3.MqttClient;

/**
 * Created by danilopereira on 19/08/17.
 */
public class MqttSubscriberImpl implements MqttSubscriber {

    private String mqttBrokerUrl;
    private String topic;
    private LockerRepositoryService lockerRepositoryService;

    public MqttSubscriberImpl(String mqttBrokerUrl, String topic, LockerRepositoryService lockerRepositoryService){
        this.mqttBrokerUrl = mqttBrokerUrl;
        this.topic = topic;
        this.lockerRepositoryService = lockerRepositoryService;
    }


    @Override
    public String consume() throws Exception {
        MqttClient client=new MqttClient(mqttBrokerUrl, MqttClient.generateClientId());
        SimpleMqttCallBack simpleMqttCallBack = new SimpleMqttCallBack(lockerRepositoryService);
        client.setCallback(simpleMqttCallBack );
        client.connect();
        client.subscribe(topic);
        return simpleMqttCallBack.getMessage();
    }
}
