package sn.uam.polytech.misid2.service;

import sn.uam.polytech.misid2.domain.Ticket;
import sn.uam.polytech.misid2.domain.TicketStatus;
import sn.uam.polytech.misid2.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> findAll() {
        return repository.findAll();
    }

    public Optional<Ticket> findOne(Long id) {
        return repository.findById(id);
    }

    public Ticket save(Ticket entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Ticket> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Ticket> findByServiceIdAndLocationId(Long serviceId, Long locationId) {
        return repository.findByServiceIdAndLocationId(serviceId, locationId);
    }

    public Optional<Ticket> findFirstWaiting(Long serviceId, Long locationId) {
        return repository.findFirstByServiceIdAndLocationIdAndStatusOrderByPositionInQueueAsc(serviceId, locationId, TicketStatus.EN_ATTENTE);
    }
}