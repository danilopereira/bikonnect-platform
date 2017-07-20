package br.com.bikonect.entities;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by danilopereira on 19/07/17.
 */
public class Rider {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private List<Bike> bikes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }
}
