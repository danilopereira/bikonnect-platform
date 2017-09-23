package br.com.bikonect.subscriber;

import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonect.entities.Locker;
import br.com.bikonect.entities.LockerPosition;
import br.com.bikonect.locker.dto.LockerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by danilopereira on 19/08/17.
 */
public class SimpleMqttCallBack implements MqttCallback {
    private LockerRepositoryService lockerRepositoryService;

    public SimpleMqttCallBack(LockerRepositoryService lockerRepositoryService){
        this.lockerRepositoryService = lockerRepositoryService;
    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT Broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message received:\n\t"+new String(mqttMessage.getPayload()));

        String message = new String(mqttMessage.getPayload());

        try {
            Locker locker = convertLockerDTOToLockerEntity(convertMessage(message));
            lockerRepositoryService.save(locker);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Locker convertLockerDTOToLockerEntity(LockerDTO lockerDTO) {
        Locker locker = lockerRepositoryService.findById(lockerDTO.getId());
        locker.setLockerPositions(parseMapToLockerPositions(lockerDTO, locker));

        return locker;
    }

    private Set<LockerPosition> parseMapToLockerPositions(LockerDTO lockerDTO, Locker locker) {
        Set<LockerPosition> lockerPositions = locker.getLockerPositions();

        LockerPosition lockerPosition = new LockerPosition();
        lockerPosition.setLatitude(lockerDTO.getPosition().getLatitude());
        lockerPosition.setLongitude(lockerDTO.getPosition().getLongitude());
        lockerPosition.setLocker(locker);

        lockerPositions.add(lockerPosition);

        return lockerPositions;
    }

    private LockerDTO convertMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(message, LockerDTO.class);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
