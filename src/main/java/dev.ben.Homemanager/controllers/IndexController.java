package dev.ben.Homemanager.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ben.Homemanager.config.jwt.TokenPayload;
import dev.ben.Homemanager.dto.UserView;
import dev.ben.Homemanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @GetMapping()
    public Optional<UserView> hello(@AuthenticationPrincipal TokenPayload token) {
        var currentUserLoggedIn = userRepository.findById(token.id());
        return currentUserLoggedIn.map(user -> mapper.map(user, UserView.class));
    }
}
