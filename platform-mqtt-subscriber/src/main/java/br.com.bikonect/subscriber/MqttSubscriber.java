package br.com.bikonect.subscriber;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by danilopereira on 26/08/17.
 */
public interface MqttSubscriber {

    MqttClient consume() throws MqttException, Exception;
}
