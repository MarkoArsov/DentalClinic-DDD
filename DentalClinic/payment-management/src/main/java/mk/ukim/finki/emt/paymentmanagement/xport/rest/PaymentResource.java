package mk.ukim.finki.emt.paymentmanagement.xport.rest;

import mk.ukim.finki.emt.paymentmanagement.domain.exceptions.PaymentNotFoundException;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.PaymentInfo;
import mk.ukim.finki.emt.paymentmanagement.services.PaymentService;
import mk.ukim.finki.emt.paymentmanagement.services.form.PaymentForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentResource {

    private final PaymentService service;

    public PaymentResource(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public void addPayment(@RequestBody PaymentForm form){
        this.service.save(form);
    }

    @PostMapping("{id}/add-info")
    public void addPaymentInfo(@RequestBody PaymentInfo paymentInfo, @PathVariable Long id) throws PaymentNotFoundException {
        this.service.addInfo(id, paymentInfo);
    }
}
