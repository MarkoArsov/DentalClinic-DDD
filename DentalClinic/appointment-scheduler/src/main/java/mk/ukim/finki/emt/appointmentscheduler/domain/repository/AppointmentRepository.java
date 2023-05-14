package mk.ukim.finki.emt.appointmentscheduler.domain.repository;

import mk.ukim.finki.emt.appointmentscheduler.domain.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
