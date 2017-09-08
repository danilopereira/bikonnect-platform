package br.com.bikonect.locker.dto;

/**
 * Created by danilopereira on 26/08/17.
 */
public class LockerDTO {
    private Long id;
    private PositionDTO position;

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
