package br.com.bikonect.locker.test;

import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonect.entities.Locker;
import br.com.bikonect.entities.LockerPosition;
import br.com.bikonect.entities.Rider;
import br.com.bikonect.locker.business.LockerBusiness;
import br.com.bikonect.locker.business.LockerBusinessImpl;
import br.com.bikonect.locker.dto.LockerLockerPositionsResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by danilopereira on 03/12/17.
 */
public class LockerBusinessImplTest {

    @Autowired
    private LockerBusiness lockerBusiness;

    @Autowired
    private LockerRepositoryService lockerRepositoryService;

    @Before
    public void setup(){

        lockerRepositoryService = mock(LockerRepositoryService.class);

        lockerBusiness = new LockerBusinessImpl(lockerRepositoryService);

        Locker locker = new Locker();
        Rider rider = new Rider();
        LockerPosition lockerPosition = new LockerPosition();

        rider.setId(1l);
        rider.setDocumentType("cpf");
        rider.setDocumentNumber("12345678900");
        rider.setName("TEST TEST");
        rider.setPublicName("TEST");
        rider.setActive(Boolean.TRUE);

        lockerPosition.setLongitude(new Float(10.0));
        lockerPosition.setLatitude(new Float(-54.231));
        lockerPosition.setId(1l);
        Set<LockerPosition> lockerPositions = new HashSet<>();
        lockerPositions.add(lockerPosition);

        locker.setPublicId("ABC123");
        locker.setId(1l);
        lockerPosition.setLocker(locker);
        rider.setLockers(Arrays.asList(locker));
        locker.setRider(rider);
        locker.setLockerPositions(lockerPositions);

        when(lockerRepositoryService.findById(any())).thenReturn(locker);
    }

    @Test
    public void testGetPositionsById(){
        LockerLockerPositionsResponse lockerLockerPositionsResponse = lockerBusiness.getPositionsById(1l);

        assertNotNull(lockerLockerPositionsResponse);
    }
}
