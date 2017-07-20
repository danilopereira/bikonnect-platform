package br.com.bikonect.entities;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by danilopereira on 19/07/17.
 */
public class Rider {

    @Id
    private String id;
    private String name;
    private String publicName;
    private DocumentType documentTypeId;
    private String documentNumber;
    private Boolean isActive;
    private Date createdAt;
    private Date updatedAt;
    private List<Bike> bikes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public DocumentType getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(DocumentType documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
