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

    private User getUserEntity(final String userName) {
        final User user = userRepository.findByName(userName);
        if (user == null) {
            return new User();
        }
        return user;
    }

    public void saveUser(final UserDTO userDTO) {
        final String userName = userDTO.getName();
        final User user = getUserEntity(userName);
        user.setName(userName);
        user.setIsAgreed(userDTO.getIsAgreed());
        final Set<Sector> sectors = userDTO.getSectors()
                .stream()
                .map(x -> sectorRepository.findById(x).get())
                .collect(Collectors.toSet());
        user.setSectors(sectors);
        userRepository.save(user);
    }

    public void fillUserData(final UserDTO userDTO) {
        final String userName = userDTO.getName();

        final User user = getUserEntity(userName);

        userDTO.setName(user.getName());
        userDTO.setIsAgreed(user.getIsAgreed());

        final Set<Integer> sectors = user.getSectors()
                .stream()
                .map(x -> x.getId())
                .collect(Collectors.toSet());
        userDTO.setSectors(sectors);
    }
}
