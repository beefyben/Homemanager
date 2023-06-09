package dev.ben.Homemanager.controllers;

import dev.ben.Homemanager.config.jwt.JwtTokenUtil;
import dev.ben.Homemanager.database.User;
import dev.ben.Homemanager.dto.AuthLoginDto;
import dev.ben.Homemanager.dto.AuthLoginView;
import dev.ben.Homemanager.dto.AuthRegisterDto;
import dev.ben.Homemanager.dto.UserView;
import dev.ben.Homemanager.exceptions.HttpBadRequestException;
import dev.ben.Homemanager.exceptions.HttpForbiddenException;
import dev.ben.Homemanager.exceptions.HttpNotFoundException;
import dev.ben.Homemanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final ModelMapper modelMapper;

    @PostMapping("/login")
    public AuthLoginView login(@RequestBody AuthLoginDto body) {
        User user = userRepository.findByEmail(body.getEmail()).orElseThrow(() -> new HttpNotFoundException("email not found"));

        if (!passwordEncoder.matches(body.getPassword(), user.getPassword())) {
            throw new HttpForbiddenException("wrong password");
        }

        LOG.info("user logged in: {}", body.getEmail());
        String token = jwtTokenUtil.generateToken(user);
        UserView userView = modelMapper.map(user, UserView.class);
        return new AuthLoginView(token, userView);
    }

    @PostMapping("/register")
    public AuthLoginView register(@RequestBody AuthRegisterDto body) {
        if (userRepository.existsByEmail(body.getEmail())) {
            throw new HttpBadRequestException("email already exists");
        }

        LOG.info("creating user with email {}", body.getEmail());
        User user = new User();
        user.setEmail(body.getEmail());
        user.setPassword(passwordEncoder.encode(body.getPassword()));
        user.setAdmin(false);
        user.setFirstname(body.getFirstname());
        user.setLastname(body.getLastname());

        userRepository.save(user);
        String token = jwtTokenUtil.generateToken(user);
        UserView userView = modelMapper.map(user, UserView.class);
        return new AuthLoginView(token, userView);
    }
}