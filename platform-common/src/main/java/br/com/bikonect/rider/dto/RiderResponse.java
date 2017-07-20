package br.com.bikonect.rider.dto;

import br.com.bikonect.bike.dto.BikeResponse;

import java.util.List;

/**
 * Created by danilopereira on 20/07/17.
 */
public class RiderResponse {
    private String fullName;
    private String documentType;
    private String documentNumber;
    private List<BikeResponse> bikes;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
