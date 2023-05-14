package mk.ukim.finki.emt.appointmentscheduler.xport.rest;

import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.AppointmentNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.TreatmentNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Treatment;
import mk.ukim.finki.emt.appointmentscheduler.services.AppointmentService;
import mk.ukim.finki.emt.appointmentscheduler.services.TreatmentService;
import mk.ukim.finki.emt.appointmentscheduler.services.form.AppointmentForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentResource {

    private final AppointmentService service;
    private final TreatmentService treatmentService;

    public AppointmentResource(AppointmentService service, TreatmentService treatmentService) {
        this.service = service;
        this.treatmentService = treatmentService;
    }

    @PostMapping
    public Appointment saveAppointment(@RequestBody AppointmentForm appointmentForm){
        return this.service.save(appointmentForm);
    }

    @GetMapping("{id}/add-treatment/{treatmentId}")
    public void addTreatmentToAppointment(@PathVariable Long id, @PathVariable Long treatmentId) throws TreatmentNotFoundException, AppointmentNotFoundException {
        Treatment treatment = treatmentService.findById(treatmentId);
        this.service.addTreatment(id, treatment);
    }

    @GetMapping("{id}/remove-treatment/{treatmentId}")
    public void removeTreatmentToAppointment(@PathVariable Long id, @PathVariable Long treatmentId) throws TreatmentNotFoundException, AppointmentNotFoundException {
        Treatment treatment = treatmentService.findById(treatmentId);
        this.service.removeTreatment(id, treatment);
    }

    @GetMapping("{id}/finalize")
    public void finalizeAppointment(@PathVariable Long id) throws AppointmentNotFoundException {
        service.finalizeAppointment(id);
    }

}
