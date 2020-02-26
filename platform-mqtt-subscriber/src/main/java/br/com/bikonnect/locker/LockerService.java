package br.com.bikonnect.locker;

import br.com.bikonnect.locker.dto.LockerDTO;

import java.util.List;


/**
 * Created by danilopereira on 26/08/17.
 */
public interface LockerService {

    void saveLockerInfo(LockerDTO lockerDTO);

    List<LockerDTO> getLockers();
}
