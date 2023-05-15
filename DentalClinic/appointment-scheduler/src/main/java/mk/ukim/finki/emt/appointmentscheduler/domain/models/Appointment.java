package mk.ukim.finki.emt.appointmentscheduler.domain.models;

import mk.ukim.finki.emt.appointmentscheduler.domain.valueobjects.DateTimeRange;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Money;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Patient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="appointment")
@Getter
public class Appointment extends AbstractEntity {

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Treatment> treatments;

    private DateTimeRange dateTimeRange;

    private Patient patient;

    private boolean finalized;

    private Appointment(Patient patient, LocalDateTime startTime) {
        this.treatments = new ArrayList<>();
        this.dateTimeRange = new DateTimeRange(startTime);
        this.patient = patient;
        this.finalized = false;
    }

    public Appointment() {}

    public static Appointment build(Patient patient, LocalDateTime startTime){
        return new Appointment(patient, startTime);
    }

    public void addTreatment(Treatment treatment){
        if (treatments.stream().filter(t -> t.getId().equals(treatment.getId())).toList().size() > 0) return;

        dateTimeRange.addTime();
        treatments.add(treatment);
    }

    public void removeTreatment(Treatment treatment){
        if (treatments.size() == 0) return;

        dateTimeRange.removeTime();
        treatments.remove(treatment);
    }

    public void setFinalized(){
        finalized = true;
    }

    public Double getPrice(){
        return treatments.stream().mapToDouble(treatment -> treatment.getPrice().getAmount()).sum();
    }

    public Money getMoney(){
        Money money = new Money(Currency.MKD, 0);
        treatments.forEach(treatment -> {
            money.add(treatment.getPrice());
        });
        return money;
    }
}
