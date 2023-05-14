package mk.ukim.finki.emt.appointmentscheduler.services.impl;

import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.AppointmentNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Treatment;
import mk.ukim.finki.emt.appointmentscheduler.domain.repository.AppointmentRepository;
import mk.ukim.finki.emt.appointmentscheduler.domain.valueobjects.Payment;
import mk.ukim.finki.emt.appointmentscheduler.services.AppointmentService;
import mk.ukim.finki.emt.appointmentscheduler.services.form.AppointmentForm;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final RestTemplate restTemplate;

    public AppointmentServiceImpl(AppointmentRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Appointment findById(Long id) throws AppointmentNotFoundException {
        return repository.findById(id).orElseThrow(AppointmentNotFoundException::new);
    }

    @Override
    public Appointment save(AppointmentForm form) {
        return this.repository.save(Appointment.build(form.getPatient(), LocalDateTime.now()));
    }

    @Override
    public void addTreatment(Long id, Treatment treatment) throws AppointmentNotFoundException {
        Appointment appointment = this.findById(id);
        if (!appointment.isFinalized()) appointment.addTreatment(treatment);
        this.repository.save(appointment);
    }

    @Override
    public void removeTreatment(Long id, Treatment treatment) throws AppointmentNotFoundException {
        Appointment appointment = this.findById(id);
        if (!appointment.isFinalized()) appointment.removeTreatment(treatment);
        this.repository.save(appointment);
    }

    @Override
    public void finalizeAppointment(Long id) throws AppointmentNotFoundException {
        Appointment appointment = this.findById(id);
        appointment.setFinalized();
        this.repository.save(appointment);
        Payment payment = new Payment(appointment.getPatient(), appointment.getPrice());
        HttpEntity<Payment> request = new HttpEntity<>(payment);
        String url = "http://localhost:9091/api/payments";
        restTemplate.postForObject(url, request, Payment.class);
    }
}
