package ru.reksoft.isa.sectorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import ru.reksoft.isa.sectorapp.beans.UserBean;
import ru.reksoft.isa.sectorapp.dto.UserDTO;
import ru.reksoft.isa.sectorapp.facade.UserFacade;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;
import ru.reksoft.isa.sectorapp.repository.UserRepository;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SectorRepository sectorRepository;
    @Resource(name = "userBean")
    private UserBean user;

    @PostMapping(value = "/save", produces = "application/json")
    public ResponseEntity<String> saveUserData(@RequestBody UserDTO userDTO) {
        user.setUserDTO(userDTO);
        new UserFacade(userRepository, sectorRepository).saveUser(user);
        return new ResponseEntity<>("{ \"message\": \"OK\" }", HttpStatus.OK);
    }

    @PostMapping(value = "/get")
    public ResponseEntity<UserDTO> getUserData() {
        final UserDTO userDTO = new UserFacade(userRepository, sectorRepository).getUserData(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    private String getSessionId() {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }
}
