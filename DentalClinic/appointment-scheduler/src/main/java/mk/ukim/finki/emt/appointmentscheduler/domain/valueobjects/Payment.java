package mk.ukim.finki.emt.appointmentscheduler.domain.valueobjects;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Money;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Patient;

@Data
public class Payment implements ValueObject {

    Patient patient;

    Double price;

    public Payment(Patient patient, double price) {
        this.patient = patient;
        this.price = price;
    }

    public Payment() {
        patient = new Patient();
        price = null;
    }
}
