package sn.uam.polytech.misid2.repository;


import sn.uam.polytech.misid2.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}