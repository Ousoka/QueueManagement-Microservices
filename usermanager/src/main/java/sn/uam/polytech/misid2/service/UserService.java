package sn.uam.polytech.misid2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sn.uam.polytech.misid2.domain.User;
import sn.uam.polytech.misid2.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}