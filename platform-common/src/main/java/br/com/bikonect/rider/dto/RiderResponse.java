package br.com.bikonect.rider.dto;

import br.com.bikonect.bike.dto.BikeResponse;
import br.com.bikonect.locker.dto.LockerResponse;

import java.util.List;

/**
 * Created by danilopereira on 20/07/17.
 */
public class RiderResponse {
    private Long id;
    private String name;
    private String publicName;
    private String documentType;
    private String documentNumber;
    private List<LockerResponse> lockerResponses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public List<LockerResponse> getLockerResponses() {
        return lockerResponses;
    }

    public void setLockerResponses(List<LockerResponse> lockerResponses) {
        this.lockerResponses = lockerResponses;
    }
}
