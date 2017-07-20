package br.com.bikonect.entities;

import org.springframework.data.annotation.Id;

/**
 * Created by danilopereira on 19/07/17.
 */
public class Bike {

    @Id
    private String id;
    private String name;

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
}
