// package sn.uam.polytech.misid2.web.rest;

// import sn.uam.polytech.misid2.domain.Ticket;
// import sn.uam.polytech.misid2.service.TicketService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/tickets")
// public class TicketResource {

//     private final TicketService service;

//     public TicketResource(TicketService service) {
//         this.service = service;
//     }

//     @GetMapping
//     public List<Ticket> getAll() {
//         return service.findAll();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Ticket> getOne(@PathVariable Long id) {
//         Optional<Ticket> result = service.findOne(id);
//         return result.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//     }

//     @PostMapping
//     public ResponseEntity<Ticket> create(@RequestBody Ticket entity) {
//         return ResponseEntity.ok(service.save(entity));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Ticket> update(@PathVariable Long id, @RequestBody Ticket entity) {
//         entity.setId(id);
//         return ResponseEntity.ok(service.save(entity));
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> delete(@PathVariable Long id) {
//         service.delete(id);
//         return ResponseEntity.noContent().build();
//     }
// }


package sn.uam.polytech.misid2.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.uam.polytech.misid2.domain.Ticket;
import sn.uam.polytech.misid2.domain.TicketStatus;
import sn.uam.polytech.misid2.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketResource {

    private final TicketService ticketService;
    public TicketResource(TicketService ticketService) { this.ticketService = ticketService; }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() { return ticketService.findAll(); }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        return ticketService.findOne(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.save(ticket));
    }

    @PatchMapping("/agent/ticket/status")
    public ResponseEntity<Ticket> updateStatus(@RequestBody Map<String, Object> payload) {
        Long id = Long.valueOf(payload.get("id").toString());
        String status = payload.get("status").toString();
        return ticketService.findOne(id).map(ticket -> {
            ticket.setStatus(TicketStatus.valueOf(status));
            return ResponseEntity.ok(ticketService.save(ticket));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/admin_home")
    public ResponseEntity<String> adminHome() {
        return ResponseEntity.ok("Admin dashboard data placeholder");
    }

    @GetMapping("/agent_home")
    public ResponseEntity<List<Ticket>> getAgentTickets(@RequestParam Long serviceId, @RequestParam Long locationId) {
        return ResponseEntity.ok(ticketService.findByServiceIdAndLocationId(serviceId, locationId));
    }

    @PostMapping("/client_obtain_ticket")
    public ResponseEntity<Ticket> obtainTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.save(ticket));
    }

    @GetMapping("/client_ticket")
    public ResponseEntity<List<Ticket>> getClientTickets(@RequestParam Long userId) {
        return ResponseEntity.ok(ticketService.findByUserId(userId));
    }
}
