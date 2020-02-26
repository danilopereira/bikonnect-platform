package br.com.bikonnect.locker.test;

import br.com.bikonnect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonnect.entities.Locker;
import br.com.bikonnect.entities.LockerPosition;
import br.com.bikonnect.entities.Rider;
import br.com.bikonnect.locker.business.LockerBusiness;
import br.com.bikonnect.locker.business.LockerBusinessImpl;
import br.com.bikonnect.locker.dto.LockerLockerPositionsResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
        rider.setCreatedAt(new Date(System.currentTimeMillis()));

        lockerPosition.setLongitude(new Float(10.0));
        lockerPosition.setLatitude(new Float(-54.231));
        lockerPosition.setId(1l);
        lockerPosition.setCreatedAt(new Date(System.currentTimeMillis()));
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
