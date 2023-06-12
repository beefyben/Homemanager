package dev.ben.Homemanager.controllers;


import dev.ben.Homemanager.config.jwt.TokenPayload;
import dev.ben.Homemanager.database.Home;
import dev.ben.Homemanager.dto.*;
import dev.ben.Homemanager.exceptions.HttpBadRequestException;
import dev.ben.Homemanager.repositories.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import dev.ben.Homemanager.repositories.UserRepository;


@RestController
@RequestMapping("/homeadd")
@RequiredArgsConstructor
public class AddHomeController {

    private final Logger LOG = LoggerFactory.getLogger(AddHomeController.class);

    private final HomeRepository homeRespository;

    private final UserRepository userRepository;


    @PostMapping("/addhome")
    public Home register(@AuthenticationPrincipal TokenPayload token, @RequestBody AddHomeDto body) {
        if (homeRespository.existsByHomeName(body.getHomename())) {
            throw new HttpBadRequestException("Home already exists");
        }

        var user = userRepository.findById(token.id()).get();

        LOG.info("creating Home with Homename {}", body.getHomename());
        Home home = new Home();
        home.setHomename(body.getHomename());
        home.setHomeaddress(body.getHomeaddress());
        home.setHomefirstdate(body.getHomefirstdate());
        home.setHomelastdate(body.getHomelastdate());
        home.setCreator(user);
        home.setNoanimal(body.isNoanimal());
        home.setNoparty(body.isNoparty());
        home.setWaterplant(body.isWaterplant());
        home.setNosound(body.isNosound());
        home.setFeedanimal(body.isFeedanimal());
        homeRespository.save(home);
        return home;
    }
}







