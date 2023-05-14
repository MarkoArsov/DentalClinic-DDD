package mk.ukim.finki.emt.paymentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class PaymentInfo implements ValueObject {

    public String cardNumber;

    public String pin;

    public PaymentInfo() {
        this.cardNumber = "";
        this.pin = "";
    }

}
