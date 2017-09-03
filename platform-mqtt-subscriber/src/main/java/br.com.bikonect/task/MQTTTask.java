package br.com.bikonect.task;

import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonect.entities.Locker;
import br.com.bikonect.entities.LockerPosition;
import br.com.bikonect.locker.dto.LockerDTO;
import br.com.bikonect.subscriber.MqttSubscriber;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danilopereira on 28/08/17.
 */
public class MQTTTask implements Runnable {

    protected String message;

    private LockerRepositoryService lockerRepositoryService;

    public MQTTTask(String message,
                    LockerRepositoryService lockerRepositoryService) {
        this.message = message;
        this.lockerRepositoryService = lockerRepositoryService;
    }

    @Override
    public void run() {
        if(message != null){

            try {
                Locker locker = convertLockerDTOToLockerEntity(convertMessage(message));
                lockerRepositoryService.save(locker);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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
