package br.com.bikonect.rider.dto;

import br.com.bikonect.bike.dto.BikeResponse;

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
    private List<BikeResponse> bikes;

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

    public List<BikeResponse> getBikes() {
        return bikes;
    }

    public void setBikes(List<BikeResponse> bikes) {
        this.bikes = bikes;
    }
}
