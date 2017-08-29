package br.com.bikonect.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by danilopereira on 26/08/17.
 */

@Entity
@Table(name = "locker")
public class Locker implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @OneToMany(mappedBy = "locker", targetEntity = LockerPosition.class, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<LockerPosition> lockerPositions;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Rider.class)
    @JoinColumn(name = "rider_id")
    private Rider rider;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<LockerPosition> getLockerPositions() {
        return lockerPositions;
    }

    public void setLockerPositions(List<LockerPosition> lockerPositions) {
        this.lockerPositions = lockerPositions;
    }
}
