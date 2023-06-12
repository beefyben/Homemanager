package dev.ben.Homemanager.controllers;

import dev.ben.Homemanager.config.jwt.TokenPayload;
import dev.ben.Homemanager.database.Home;
import dev.ben.Homemanager.dto.UserView;
import dev.ben.Homemanager.repositories.HomeRepository;
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
    private final HomeRepository homeRepository;
    private final ModelMapper mapper;

    @GetMapping("current-user")
    public Optional<UserView> hello(@AuthenticationPrincipal TokenPayload token) {
        var currentUserLoggedIn = userRepository.findById(token.id());
        return currentUserLoggedIn.map(user -> mapper.map(user, UserView.class));
    }

    @GetMapping("homes")
    public Iterable<Home> getHomes() {
        return homeRepository.findAll();
    }
}
