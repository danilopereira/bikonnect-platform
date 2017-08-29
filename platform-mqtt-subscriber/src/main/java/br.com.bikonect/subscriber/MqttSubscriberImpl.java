package br.com.bikonect.subscriber;

import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonect.entities.Locker;
import br.com.bikonect.entities.LockerPosition;
import br.com.bikonect.locker.dto.LockerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public MqttClient consume() throws Exception {
        MqttClient client=new MqttClient(mqttBrokerUrl, MqttClient.generateClientId());
        SimpleMqttCallBack simpleMqttCallBack = new SimpleMqttCallBack();
        client.setCallback(simpleMqttCallBack );
        client.connect();
//        client.subscribe(topic);
//        Locker locker = convertLockerDTOToLockerEntity(convertMessage(simpleMqttCallBack.getMessage()));
//
//        lockerRepositoryService.save(locker);

        return client;

    }

    private Locker convertLockerDTOToLockerEntity(LockerDTO lockerDTO) {
        Locker locker = new Locker();

        locker.setId(lockerDTO.getId());
        locker.setLockerPositions(parseMapToLockerPositions(lockerDTO));

        return null;
    }

    private List<LockerPosition> parseMapToLockerPositions(LockerDTO lockerDTO) {
        List<LockerPosition> lockerPositions = new ArrayList<>();

        LockerPosition lockerPosition = new LockerPosition();
        lockerPosition.setLatitude(lockerDTO.getPosition().getLatitude());
        lockerPosition.setLongitude(lockerDTO.getPosition().getLongitude());

        lockerPositions.add(lockerPosition);

        return lockerPositions;
    }

    private LockerDTO convertMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(message, LockerDTO.class);
    }
}
