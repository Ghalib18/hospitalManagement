package com.ghalib.hospitalManagement.security;

import com.ghalib.hospitalManagement.dto.LoginRequestDto;
import com.ghalib.hospitalManagement.dto.LoginResponseDto;
import com.ghalib.hospitalManagement.dto.SignUpRequestDto;
import com.ghalib.hospitalManagement.dto.SignupResponseDto;
import com.ghalib.hospitalManagement.entity.Patient;
import com.ghalib.hospitalManagement.entity.User;
import com.ghalib.hospitalManagement.entity.type.RoleType;
import com.ghalib.hospitalManagement.repo.PatientRepo;
import com.ghalib.hospitalManagement.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PatientRepo patientRepo;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getPassword())
        );
        User user= (User)authentication.getPrincipal();
        String token=authUtil.generateAccessToken(user);

        return new LoginResponseDto(token, user.getId());
    }

    public SignupResponseDto signup(SignUpRequestDto signupRequestDto){
        User user= userRepository.findByemail(signupRequestDto.getEmail()).orElse(null);

        if(user != null) throw new IllegalArgumentException("User Already Exists");

        user=userRepository.save(User.builder()
                        .name(signupRequestDto.getName())
                        .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                        .email(signupRequestDto.getEmail())
                        .roles(Set.of(RoleType.PATIENT))
                        .build());

        Patient patient= Patient.builder()
                .name(user.getName())
                .email(user.getEmail())
                .user(user)
                .build();

        patientRepo.save(patient);

        return new SignupResponseDto(user.getId(),user.getEmail());
    }

}
