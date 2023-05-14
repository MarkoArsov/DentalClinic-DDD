package mk.ukim.finki.emt.paymentmanagement.services.impl;

import mk.ukim.finki.emt.paymentmanagement.domain.exceptions.PaymentNotFoundException;
import mk.ukim.finki.emt.paymentmanagement.domain.models.Payment;
import mk.ukim.finki.emt.paymentmanagement.domain.repository.PaymentRepository;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.PaymentInfo;
import mk.ukim.finki.emt.paymentmanagement.services.PaymentService;
import mk.ukim.finki.emt.paymentmanagement.services.form.PaymentForm;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Money;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment findById(Long id) throws PaymentNotFoundException {
        return repository.findById(id).orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Payment> findAllByPatientEmail(String email) {
        List<Payment> payments = this.findAll();
        return payments.stream().filter(payment -> payment.patient.getEmail().equals(email)).collect(Collectors.toList());
    }

    @Override
    public Payment save(PaymentForm form) {
        return this.repository.save(Payment.build(form.getPatient(), new Money(Currency.MKD, form.getPrice())));
    }

    @Override
    public Payment addInfo(Long id, PaymentInfo info) throws PaymentNotFoundException {
        Payment payment = this.findById(id);
        payment.addPaymentInfo(info);
        return this.repository.save(payment);
    }

}
