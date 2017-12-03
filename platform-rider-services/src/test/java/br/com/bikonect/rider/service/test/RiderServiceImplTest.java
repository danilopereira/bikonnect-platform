package br.com.bikonect.rider.service.test;

import br.com.bikonect.dao.documentType.repository.DocumentTypeRepositoryService;
import br.com.bikonect.dao.rider.repository.RiderRepositoryService;
import br.com.bikonect.entities.DocumentType;
import br.com.bikonect.entities.Locker;
import br.com.bikonect.entities.Rider;
import br.com.bikonect.rider.dto.RiderRequest;
import br.com.bikonect.rider.dto.RiderResponse;
import br.com.bikonect.rider.service.RiderService;
import br.com.bikonect.rider.service.RiderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by danilopereira on 03/12/17.
 */
public class RiderServiceImplTest {

    @Autowired
    private RiderService riderService;

    @Autowired
    private RiderRepositoryService riderRepositoryService;

    @Autowired
    private DocumentTypeRepositoryService documentTypeRepositoryService;

    @Before
    public void setup(){
        riderRepositoryService = mock(RiderRepositoryService.class);
        documentTypeRepositoryService = mock(DocumentTypeRepositoryService.class);

        riderService = new RiderServiceImpl(riderRepositoryService, documentTypeRepositoryService);
    }

    @Test
    public void testSave(){
        RiderRequest request = new RiderRequest();
        request.setDocumentNumber("12345678900");
        request.setName("TEST TEST");
        request.setDocumentType("cpf");

        DocumentType documentType = new DocumentType();
        documentType.setId(1l);
        documentType.setName("cpf");

        Locker locker = new Locker();
        locker.setId(1l);
        locker.setPublicId("ABC123");

        Rider rider = new Rider();

        rider.setActive(Boolean.TRUE);
        rider.setPublicName("TEST");
        rider.setName(request.getName());
        rider.setDocumentNumber(rider.getDocumentNumber());
        rider.setDocumentType(request.getDocumentType());
        rider.setId(1l);
        locker.setRider(rider);
        rider.setLockers(Arrays.asList(locker));
        when(documentTypeRepositoryService.findByName(documentType.getName())).thenReturn(documentType);
        when(riderRepositoryService.save(any())).thenReturn(rider);

        RiderResponse riderResponse = riderService.save(request);

        assertNotNull(riderResponse);
        assertEquals(request.getName(), riderResponse.getName());
    }

    @Test
    public void testFindById(){
        Locker locker = new Locker();
        locker.setId(1l);
        locker.setPublicId("ABC123");

        Rider rider = new Rider();

        rider.setActive(Boolean.TRUE);
        rider.setPublicName("TEST");
        rider.setName("TEST TEST");
        rider.setDocumentNumber(rider.getDocumentNumber());
        rider.setDocumentType("cpf");
        rider.setId(1l);
        locker.setRider(rider);
        rider.setLockers(Arrays.asList(locker));
        when(riderRepositoryService.findById(anyLong())).thenReturn(rider);

        RiderResponse riderResponse = riderService.findById(1l);

        assertNotNull(riderResponse);
    }

    @Test
    public void listRiders(){
        Locker locker = new Locker();
        locker.setId(1l);
        locker.setPublicId("ABC123");

        Rider rider = new Rider();

        rider.setActive(Boolean.TRUE);
        rider.setPublicName("TEST");
        rider.setName("TEST TEST");
        rider.setDocumentNumber(rider.getDocumentNumber());
        rider.setDocumentType("cpf");
        rider.setId(1l);
        locker.setRider(rider);
        rider.setLockers(Arrays.asList(locker));
        List<Rider> riderList = Arrays.asList(rider);
        when(riderRepositoryService.findAll()).thenReturn(riderList);

        List<RiderResponse> riderResponses = riderService.listRiders();

        assertNotNull(riderResponses);
        assertFalse(riderResponses.isEmpty());
    }
}
