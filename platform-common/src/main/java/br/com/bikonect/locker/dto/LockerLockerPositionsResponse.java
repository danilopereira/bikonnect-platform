package br.com.bikonect.locker.dto;

import br.com.bikonect.entities.LockerPosition;
import br.com.bikonect.lockerposition.dto.LockerPositionResponse;

import java.util.List;

/**
 * Created by danilopereira on 23/09/17.
 */
public class LockerLockerPositionsResponse {
    private Long id;
    private String publicId;
    private List<LockerPositionResponse> lockerPositions;

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

    public List<LockerPositionResponse> getLockerPositions() {
        return lockerPositions;
    }

    public void setLockerPositions(List<LockerPositionResponse> lockerPositions) {
        this.lockerPositions = lockerPositions;
    }
}
