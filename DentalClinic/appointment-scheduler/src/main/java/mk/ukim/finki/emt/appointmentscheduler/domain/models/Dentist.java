package mk.ukim.finki.emt.appointmentscheduler.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Name;

@Entity
@Table(name="dentist")
@Getter
public class Dentist extends AbstractEntity {

    private Name name;

    private String email;

    private Dentist(Name name, String email) {
        this.name = name;
        this.email = email;
    }

    public Dentist() {}

    public static Dentist build(Name name, String email){
        return new Dentist(name, email);
    }

}
