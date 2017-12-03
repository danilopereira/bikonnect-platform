package br.com.bikonect.locker;

import br.com.bikonect.locker.dto.LockerDTO;

import java.util.List;


/**
 * Created by danilopereira on 26/08/17.
 */
public interface LockerService {

    void saveLockerInfo(LockerDTO lockerDTO);

    List<LockerDTO> getLockers();
}
