package ru.reksoft.isa.sectorapp.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.reksoft.isa.sectorapp.dto.UserDTO;

@Component
@Scope("session")
public class UserBean {
    private UserDTO userDTO;

    public UserBean() {
        this.userDTO = new UserDTO();
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
