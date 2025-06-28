package sn.uam.polytech.misid2.repository;


import java.util.List;

import sn.uam.polytech.misid2.domain.OKService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<OKService, Long> {
}