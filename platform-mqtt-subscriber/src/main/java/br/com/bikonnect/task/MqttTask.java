package br.com.bikonnect.task;

import br.com.bikonnect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonnect.entities.Locker;
import br.com.bikonnect.entities.LockerPosition;
import br.com.bikonnect.locker.dto.LockerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

/**
 * Created by danilopereira on 26/09/17.
 */
public class MqttTask implements Runnable{

    private String message;

    private LockerRepositoryService lockerRepositoryService;

    public MqttTask(String message, LockerRepositoryService lockerRepositoryService){
        this.message = message;
        this.lockerRepositoryService = lockerRepositoryService;
    }

    @Override
    public void run() {
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
        lockerPosition.setCreatedAt(new Date(System.currentTimeMillis()));

        lockerPositions.add(lockerPosition);

        return lockerPositions;
    }

    private LockerDTO convertMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(message, LockerDTO.class);
    }
}
