package br.com.bikonect.task;

import br.com.bikonect.subscriber.MqttSubscriber;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by danilopereira on 28/08/17.
 */
public class MQTTTask implements Runnable {

    protected MqttClient client;
    protected String topic;

    public MQTTTask(MqttClient client, String topic) {
        this.client = client;
        this.topic = topic;
    }

    @Override
    public void run() {
        try {
            client.subscribe(topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}
