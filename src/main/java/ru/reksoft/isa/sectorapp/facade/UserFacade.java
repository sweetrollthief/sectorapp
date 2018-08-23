package ru.reksoft.isa.sectorapp.facade;

import ru.reksoft.isa.sectorapp.dao.Sector;
import ru.reksoft.isa.sectorapp.dao.User;
import ru.reksoft.isa.sectorapp.dto.UserDTO;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;
import ru.reksoft.isa.sectorapp.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class UserFacade {
    private final UserRepository userRepository;
    private final SectorRepository sectorRepository;

    public UserFacade(final UserRepository userRepository, final SectorRepository sectorRepository) {
        this.userRepository = userRepository;
        this.sectorRepository = sectorRepository;
    }

    private User getUserEntity(final String sessionId) {
        User user = userRepository.findBySessionId(sessionId);
        if (user == null) {
            user = new User();
            user.setSessionId(sessionId);
            userRepository.save(user);
        }
        return user;
    }

    public void saveUser(final UserDTO userDTO, final String sessionId) {
        final User user = getUserEntity(sessionId);
        user.setName(userDTO.getName());
        user.setIsAgreed(userDTO.getIsAgreed());
        final Set<Sector> sectors = userDTO.getSectors()
                .stream()
                .map(x -> sectorRepository.findById(x).get())
                .collect(Collectors.toSet());
        user.setSectors(sectors);
        userRepository.save(user);
    }

    public UserDTO getUser(final String sessionId) {
        final User user = getUserEntity(sessionId);
        final UserDTO userDTO = new UserDTO();

        userDTO.setName(user.getName());
        userDTO.setIsAgreed(user.getIsAgreed());

        final Set<Integer> sectors = user.getSectors()
                .stream()
                .map(x -> x.getId())
                .collect(Collectors.toSet());
        userDTO.setSectors(sectors);

        return userDTO;
    }
}
