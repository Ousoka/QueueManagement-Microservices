package sn.uam.polytech.misid2.web.rest;

import sn.uam.polytech.misid2.domain.OKService;
import sn.uam.polytech.misid2.service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceResource {

    private final ServiceService service;

    public ServiceResource(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<OKService> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OKService> getOne(@PathVariable Long id) {
        Optional<OKService> result = service.findOne(id);
        return result.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OKService> create(@RequestBody OKService entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OKService> update(@PathVariable Long id, @RequestBody OKService entity) {
        entity.setId(id);
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}