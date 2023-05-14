package mk.ukim.finki.emt.appointmentscheduler.xport.rest;


import mk.ukim.finki.emt.appointmentscheduler.domain.models.Treatment;
import mk.ukim.finki.emt.appointmentscheduler.services.TreatmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentResource {
    private final TreatmentService service;

    public TreatmentResource(TreatmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Treatment> getAll(){
        return this.service.findAll();
    }

}
