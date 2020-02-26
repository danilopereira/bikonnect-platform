package br.com.bikonnect.lockerposition.dto;

/**
 * Created by danilopereira on 23/09/17.
 */
public class LockerPositionResponse {
    private Float latitude;
    private Float longitude;
    private String date;

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
