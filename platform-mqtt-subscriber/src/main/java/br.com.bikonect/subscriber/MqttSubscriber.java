package br.com.bikonect.subscriber;

import br.com.bikonect.handler.MqttHandler;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by danilopereira on 26/08/17.
 */
public interface MqttSubscriber {

    void consume(MqttHandler mqttHandler) throws MqttException, Exception;
}
