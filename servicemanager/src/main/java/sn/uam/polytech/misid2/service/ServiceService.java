package sn.uam.polytech.misid2.service;

import sn.uam.polytech.misid2.domain.OKService;
import sn.uam.polytech.misid2.repository.ServiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<OKService> findAll() {
        return repository.findAll();
    }

    public Optional<OKService> findOne(Long id) {
        return repository.findById(id);
    }

    public OKService save(OKService entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}