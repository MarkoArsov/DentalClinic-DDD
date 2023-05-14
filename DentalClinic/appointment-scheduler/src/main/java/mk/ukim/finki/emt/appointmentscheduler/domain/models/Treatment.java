package mk.ukim.finki.emt.appointmentscheduler.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Money;

@Entity
@Table(name="treatment")
@Getter
public class Treatment extends AbstractEntity {

    private String name;

    private String description;

    private Money price;

    @ManyToOne
    private Dentist dentist;

    private Treatment(String name, String description, Money price, Dentist dentist) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dentist = dentist;
    }

    public Treatment() {}

    public static Treatment build(String name, String description, Money price, Dentist dentist){
        return new Treatment(name, description, price, dentist);
    }
}
