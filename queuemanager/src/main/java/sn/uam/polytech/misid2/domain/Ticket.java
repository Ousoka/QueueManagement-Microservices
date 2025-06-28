package sn.uam.polytech.misid2.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketNumber;

    private Long serviceId;

    //plusieurs tickets pour un {service,localisation}
    private Long locationId; 

    private Long userId;

    @Column(nullable = true)
    private Long positionInQueue;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.EN_ATTENTE;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    // Getter and Setter localisation
    public Long getLocationId() {
        return locationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPositionInQueue() {
        return positionInQueue;
    }

    public void setPositionInQueue(Long positionInQueue) {
        this.positionInQueue = positionInQueue;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }


}