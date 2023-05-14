package mk.ukim.finki.emt.paymentmanagement.services;

import mk.ukim.finki.emt.paymentmanagement.domain.exceptions.PaymentNotFoundException;
import mk.ukim.finki.emt.paymentmanagement.domain.models.Payment;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.PaymentInfo;
import mk.ukim.finki.emt.paymentmanagement.services.form.PaymentForm;

import java.util.List;

public interface PaymentService {

    Payment findById(Long id) throws PaymentNotFoundException;

    List<Payment> findAll();

    List<Payment> findAllByPatientEmail(String email);

    Payment save(PaymentForm form);

    Payment addInfo(Long id, PaymentInfo info) throws PaymentNotFoundException;
}
