package sn.uam.polytech.misid2.security;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sn.uam.polytech.misid2.domain.User;
import sn.uam.polytech.misid2.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String numeroTel) throws UsernameNotFoundException {
        System.out.println("Loading user by phone number: " + numeroTel); // Debug
        User user = userRepository.findByNumeroTel(numeroTel)
                .orElseThrow(() -> {
                    System.out.println("User not found for phone number: " + numeroTel); // Debug
                    return new UsernameNotFoundException("User not found");
                });

        System.out.println("User loaded: " + user); // Debug
        return new org.springframework.security.core.userdetails.User(
                user.getNumeroTel(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))
        );
    }
}