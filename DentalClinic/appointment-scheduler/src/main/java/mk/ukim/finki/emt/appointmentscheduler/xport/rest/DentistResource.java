package mk.ukim.finki.emt.appointmentscheduler.xport.rest;

import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.DentistNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Dentist;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Treatment;
import mk.ukim.finki.emt.appointmentscheduler.services.DentistService;
import mk.ukim.finki.emt.appointmentscheduler.services.TreatmentService;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Money;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dentists")
public class DentistResource {

    private final DentistService service;
    private final TreatmentService treatmentService;

    public DentistResource(DentistService service, TreatmentService treatmentService) {
        this.service = service;
        this.treatmentService = treatmentService;

//        Dentist dentist = this.service.save(Dentist.build(new Name("Marko", "Arsov"),"arsovmarko@gmail.com"));
//        this.treatmentService.save(Treatment.build(
//                "Braces",
//                "Braces (orthodontic treatment) straighten or move teeth to improve the appearance of the teeth and how they work.",
//                new Money(Currency.MKD,10000),
//                dentist));
//        this.treatmentService.save(Treatment.build(
//                "Implants",
//                "Implants are a fixed alternative to removable dentures.",
//                new Money(Currency.MKD,6000),
//                dentist));
//        this.treatmentService.save(Treatment.build(
//                "Dentures",
//                "More commonly known as false teeth, dentures are fitted in place of natural teeth.",
//                new Money(Currency.MKD,16000),
//                dentist));
    }

    @GetMapping
    public List<Dentist> getAll(){
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Dentist getById(@PathVariable Long id) throws DentistNotFoundException {
        return this.service.findById(id);
    }

    @GetMapping("{id}/treatments")
    public List<Treatment> getTreatmentsByDentist(@PathVariable Long id) throws DentistNotFoundException {
        return this.treatmentService.findAllByDentist(this.service.findById(id));
    }
}
