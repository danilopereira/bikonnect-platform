package br.com.bikonect.subscriber;

import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonect.entities.Locker;
import br.com.bikonect.entities.LockerPosition;
import br.com.bikonect.handler.MqttHandler;
import br.com.bikonect.locker.dto.LockerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.*;

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
