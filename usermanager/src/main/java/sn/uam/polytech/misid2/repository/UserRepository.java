package sn.uam.polytech.misid2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.uam.polytech.misid2.domain.Role;
import sn.uam.polytech.misid2.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(Role role);
    Optional<User> findByNumeroTel(String numeroTel);

}