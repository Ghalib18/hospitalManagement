package com.ghalib.hospitalManagement.security;

import com.ghalib.hospitalManagement.entity.User;
import com.ghalib.hospitalManagement.entity.type.RoleType;
import com.ghalib.hospitalManagement.repo.PatientRepo;
import com.ghalib.hospitalManagement.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AdminInit  implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${admin.username}")
    String username;
    @Value("${admin.password}")
    String password;
    @Value("${admin.email}")
    String email;


    @Override
    public void run(String... args) throws Exception {

        User user= userRepository.findByemail(email).orElse(null);
        if(user==null){
            user= User.builder()
                    .name(username)
                    .password(passwordEncoder.encode(password))
                    .email(email)
                    .roles(Set.of(RoleType.ADMIN))
                    .build();

            userRepository.save(user);
        }

    }
}
