package mk.ukim.finki.emt.appointmentscheduler.services;

import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.DentistNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Dentist;


import java.util.List;

public interface DentistService {

    Dentist save(Dentist dentist);

    List<Dentist> findAll();

    Dentist findById(Long id) throws DentistNotFoundException;

    Dentist findByEmail(String email) throws DentistNotFoundException;
}
