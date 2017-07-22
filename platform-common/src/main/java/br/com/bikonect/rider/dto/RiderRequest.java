package br.com.bikonect.rider.dto;

import com.sun.istack.internal.NotNull;

/**
 * Created by danilopereira on 20/07/17.
 */
public class RiderRequest {
    private Long id;
    @NotNull
    private String name;
    private String documentType;
    private String documentNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
