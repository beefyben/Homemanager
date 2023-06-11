package dev.ben.Homemanager.controllers;

import dev.ben.Homemanager.config.jwt.JwtTokenUtil;
import dev.ben.Homemanager.config.jwt.TokenPayload;
import dev.ben.Homemanager.database.Homes;
import dev.ben.Homemanager.dto.*;
import dev.ben.Homemanager.exceptions.HttpBadRequestException;
import dev.ben.Homemanager.repositories.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import dev.ben.Homemanager.repositories.UserRepository;
import dev.ben.Homemanager.dto.AddHomeView;
import dev.ben.Homemanager.dto.HomeView;



@RestController
@RequestMapping("/homeadd")
@RequiredArgsConstructor
public class AddHomeController {

    private final Logger LOG = LoggerFactory.getLogger(AddHomeController.class);

    private final HomeRepository homeRespository;

    private final UserRepository userRepository;

    @PostMapping("/addhome")
    public Homes register(@AuthenticationPrincipal TokenPayload token, @RequestBody AddHomeDto body) {
        if (homeRespository.existsByHomeName(body.getHomename())) {
            throw new HttpBadRequestException("Home already exists");
        }

        var user = userRepository.findById(token.id()).get();

        LOG.info("creating Home with Homename {}", body.getHomename());
        Homes homes = new Homes();
        homes.setHomename(body.getHomename());
        homes.setHomeaddress(body.getHomeaddress());
        homes.setCreator(user);
        homes.setNoanimal(body.isNoanimal());
        homeRespository.save(homes);
        return homes;
    }
}






