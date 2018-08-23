package ru.reksoft.isa.sectorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import ru.reksoft.isa.sectorapp.dto.UserDTO;
import ru.reksoft.isa.sectorapp.facade.UserFacade;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;
import ru.reksoft.isa.sectorapp.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SectorRepository sectorRepository;

    @PostMapping(value = "/save", produces = "application/json")
    public ResponseEntity<String> saveUserData(@RequestBody UserDTO user) {
        final String sessionId = getSessionId();
        new UserFacade(userRepository, sectorRepository).saveUser(user, sessionId);
        return new ResponseEntity<>("{ \"message\": \"OK\" }", HttpStatus.OK);
    }

    @PostMapping(value = "/get")
    public ResponseEntity<UserDTO> getUserData() {
        final String sessionId = getSessionId();
        final UserDTO user = new UserFacade(userRepository, sectorRepository).getUser(sessionId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private String getSessionId() {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }
}
