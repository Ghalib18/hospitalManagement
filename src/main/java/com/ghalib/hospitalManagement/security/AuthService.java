package com.ghalib.hospitalManagement.security;

import com.ghalib.hospitalManagement.dto.LoginRequestDto;
import com.ghalib.hospitalManagement.dto.LoginResponseDto;
import com.ghalib.hospitalManagement.dto.SignupResponseDto;
import com.ghalib.hospitalManagement.entity.User;
import com.ghalib.hospitalManagement.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;

    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword())
        );
        User user= (User)authentication.getPrincipal();
        String token=authUtil.generateAccessToken(user);

        return new LoginResponseDto(token, user.getId());
    }

    public SignupResponseDto signup(LoginRequestDto signupRequestDto){
        User user= userRepository.findByUserName(signupRequestDto.getUsername()).orElse(null);

        if(user != null) throw new IllegalArgumentException("User Already Exists");

        user=userRepository.save(User.builder()
                        .username(signupRequestDto.getUsername())
                        .password(signupRequestDto.getPassword())
                        .build());

        return new SignupResponseDto(user.getId(),user.getUsername());
    }

}
