package br.com.bikonnect.subscriber;

import br.com.bikonnect.handler.MqttHandler;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by danilopereira on 19/08/17.
 */
public class SimpleMqttCallBack implements MqttCallback {

    private MqttHandler mqttHandler;

    public SimpleMqttCallBack(MqttHandler mqttHandler){
        this.mqttHandler = mqttHandler;
    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT Broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message received:\n\t" + new String(mqttMessage.getPayload()));

        String message = new String(mqttMessage.getPayload());

        mqttHandler.setMessage(message);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
