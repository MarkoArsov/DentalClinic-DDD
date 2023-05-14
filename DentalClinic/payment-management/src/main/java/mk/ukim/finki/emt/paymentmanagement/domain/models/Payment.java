package mk.ukim.finki.emt.paymentmanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.PaymentInfo;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Money;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Patient;

@Entity
@Table(name="payment")
@Getter
public class Payment extends AbstractEntity {

    public Patient patient;

    public Money price;

    public PaymentInfo paymentInfo;

    private Payment(Patient patient, Money price) {
        this.patient = patient;
        this.price = price;
        this.paymentInfo = null;
    }

    public Payment() {}

    public static Payment build(Patient patient, Money price){
        return new Payment(patient, price);
    }

    public void addPaymentInfo(PaymentInfo info){
        this.paymentInfo = info;
    }
}
