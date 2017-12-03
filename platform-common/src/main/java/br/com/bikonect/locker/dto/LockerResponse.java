package br.com.bikonect.locker.dto;

/**
 * Created by danilopereira on 23/09/17.
 */
public class LockerResponse {
    private Long id;
    private String publicId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
}
