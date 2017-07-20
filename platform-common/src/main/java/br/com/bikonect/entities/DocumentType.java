package br.com.bikonect.entities;

import org.springframework.data.annotation.Id;

/**
 * Created by danilopereira on 20/07/17.
 */
public class DocumentType {

    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
