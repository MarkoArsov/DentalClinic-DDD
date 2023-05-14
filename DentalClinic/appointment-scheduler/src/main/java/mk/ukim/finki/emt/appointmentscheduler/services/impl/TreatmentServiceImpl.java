package mk.ukim.finki.emt.appointmentscheduler.services.impl;

import mk.ukim.finki.emt.appointmentscheduler.domain.exceptions.TreatmentNotFoundException;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Dentist;
import mk.ukim.finki.emt.appointmentscheduler.domain.models.Treatment;
import mk.ukim.finki.emt.appointmentscheduler.domain.repository.TreatmentRepository;
import mk.ukim.finki.emt.appointmentscheduler.services.TreatmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository repository;

    public TreatmentServiceImpl(TreatmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Treatment save(Treatment treatment) {
        return repository.save(treatment);
    }

    @Override
    public List<Treatment> findAll() {
        return repository.findAll();
    }

    @Override
    public Treatment findById(Long id) throws TreatmentNotFoundException {
        return repository.findById(id).orElseThrow(TreatmentNotFoundException::new);
    }

    @Override
    public Treatment findByName(String name) throws TreatmentNotFoundException {
        return repository.findByName(name).orElseThrow(TreatmentNotFoundException::new);
    }

    @Override
    public List<Treatment> findAllByDentist(Dentist dentist) {
        return repository.findAll().stream().filter(treatment -> treatment.getDentist().getEmail().equals(dentist.getEmail())).collect(Collectors.toList());
    }
}
