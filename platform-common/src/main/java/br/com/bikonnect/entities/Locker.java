package br.com.bikonnect.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by danilopereira on 26/08/17.
 */

@Entity
@Table(name = "locker")
public class Locker implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "public_id")
    private String publicId;

    @OneToMany(mappedBy = "locker", targetEntity = LockerPosition.class, cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<LockerPosition> lockerPositions = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Rider.class)
    @JoinColumn(name = "rider_id")
    private Rider rider;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<LockerPosition> getLockerPositions() {
        return lockerPositions;
    }

    public void setLockerPositions(Set<LockerPosition> lockerPositions) {
        this.lockerPositions = lockerPositions;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }
}
