package mk.ukim.finki.emt.appointmentscheduler.services;

import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.TreatmentNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Dentist;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Treatment;

import java.util.List;

public interface TreatmentService {

    Treatment save(Treatment treatment);

    List<Treatment> findAll();

    Treatment findById(Long id) throws TreatmentNotFoundException;

    Treatment findByName(String name) throws TreatmentNotFoundException;

    List<Treatment> findAllByDentist(Dentist dentist);
}
