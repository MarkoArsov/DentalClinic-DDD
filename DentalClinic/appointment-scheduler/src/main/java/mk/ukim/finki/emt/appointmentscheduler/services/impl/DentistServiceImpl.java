package mk.ukim.finki.emt.appointmentscheduler.services.impl;

import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.DentistNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Dentist;
import mk.ukim.finki.emt.appointmentscheduler.domain.repository.DentistRepository;
import mk.ukim.finki.emt.appointmentscheduler.services.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository repository;

    public DentistServiceImpl(DentistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return repository.save(dentist);
    }

    @Override
    public List<Dentist> findAll() {
        return repository.findAll();
    }

    @Override
    public Dentist findById(Long id) throws DentistNotFoundException {
        return repository.findById(id).orElseThrow(DentistNotFoundException::new);
    }

    @Override
    public Dentist findByEmail(String email) throws DentistNotFoundException {
        return repository.findByEmail(email).orElseThrow(DentistNotFoundException::new);
    }
}
