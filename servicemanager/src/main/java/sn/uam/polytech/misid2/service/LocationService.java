package sn.uam.polytech.misid2.service;

import sn.uam.polytech.misid2.domain.Location;
import sn.uam.polytech.misid2.repository.LocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> findAll() {
        return repository.findAll();
    }

    public Optional<Location> findOne(Long id) {
        return repository.findById(id);
    }

    public Location save(Location entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}