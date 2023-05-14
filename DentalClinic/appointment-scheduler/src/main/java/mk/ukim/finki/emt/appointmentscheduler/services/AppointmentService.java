package mk.ukim.finki.emt.appointmentscheduler.services;

import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.AppointmentNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Dentist;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Treatment;
import mk.ukim.finki.emt.appointmentscheduler.services.form.AppointmentForm;

public interface AppointmentService {

    Appointment findById(Long id) throws AppointmentNotFoundException;

    Appointment save(AppointmentForm form);

    void addTreatment(Long id, Treatment treatment) throws AppointmentNotFoundException;

    void removeTreatment(Long id, Treatment treatment) throws AppointmentNotFoundException;
    
    void finalizeAppointment(Long id) throws AppointmentNotFoundException;

}
