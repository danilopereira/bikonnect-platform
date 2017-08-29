package br.com.bikonect.locker.dto;

/**
 * Created by danilopereira on 26/08/17.
 */
public class LockerDTO {
    private String id;
    private PositionDTO position;

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
