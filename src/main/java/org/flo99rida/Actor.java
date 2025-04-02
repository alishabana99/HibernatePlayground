package org.flo99rida;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.logging.Logger;

// the name used in 'HQL'
@Entity(name = "ACTOR")
// the name used in 'SQL'
@Table(name = "actor")
public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdateTs;
    private String fullName;


    @Id
    @Column(name = "actor_id")
    public int getActorId() {
        System.out.println("GOT: "+actorId); // verifying getter call while persisting the object
        return actorId;
    }
    public void setActorId(int actorId) {
        System.out.println("SET: "+actorId); // verifying setter call while persisting the object
        this.actorId = actorId;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "last_update")
    public Timestamp getLastUpdateTs() {
        return lastUpdateTs;
    }
    public void setLastUpdateTs(Timestamp lastUpdateTs) {
        this.lastUpdateTs = lastUpdateTs;
    }


    @Transient
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "Actor{" + "\n" +
                "actorId=" + actorId + "\n" +
                ", firstName='" + firstName + "\n" +
                ", lastName='" + lastName + "\n" +
                ", lastUpdateTs=" + lastUpdateTs + "\n" +
                "}";
    }
}
