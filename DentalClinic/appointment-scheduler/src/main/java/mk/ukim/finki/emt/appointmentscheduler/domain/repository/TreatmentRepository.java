package mk.ukim.finki.emt.appointmentscheduler.domain.repository;

import mk.ukim.finki.emt.appointmentscheduler.domain.models.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    Optional<Treatment> findByName(String name);
}
