package mk.ukim.finki.emt.paymentmanagement.services.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Money;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Patient;

@Data
public class PaymentForm {

    Patient patient;

    Double price;
}
