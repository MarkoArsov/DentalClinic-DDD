package mk.ukim.finki.emt.appointmentscheduler.domain.repository;

import mk.ukim.finki.emt.appointmentscheduler.domain.models.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    Optional<Dentist> findByEmail(String email);
}
