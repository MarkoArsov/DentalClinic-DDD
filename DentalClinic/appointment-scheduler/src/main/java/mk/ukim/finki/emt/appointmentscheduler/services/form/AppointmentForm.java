package mk.ukim.finki.emt.appointmentscheduler.services.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Patient;

import java.time.LocalDateTime;

@Data
public class AppointmentForm {

    Patient patient;
}
