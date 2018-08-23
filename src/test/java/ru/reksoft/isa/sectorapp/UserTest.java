package ru.reksoft.isa.sectorapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.reksoft.isa.sectorapp.dto.UserDTO;
import ru.reksoft.isa.sectorapp.entity.User;
import ru.reksoft.isa.sectorapp.facade.UserFacade;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;
import ru.reksoft.isa.sectorapp.repository.UserRepository;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestPropertySource(locations="classpath:test.properties")
public class UserTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SectorRepository sectorRepository;

    private final static String REFERENCE_NAME = "dummyName";
    private final static boolean REFERENCE_AGREED = false;

    @Test
    public void testEntity() {
        final User createdUserEntity = createUserEntity(REFERENCE_NAME);
        createdUserEntity.setName(REFERENCE_NAME);
        createdUserEntity.setIsAgreed(REFERENCE_AGREED);

        userRepository.save(createdUserEntity);

        final User loadedUserEntity = userRepository.findByName(REFERENCE_NAME);

        assertEquals(loadedUserEntity.getName(), REFERENCE_NAME);
        assertEquals(loadedUserEntity.getIsAgreed(), REFERENCE_AGREED);
    }

    @Test
    public void testUserService() {
        final UserFacade userService = new UserFacade(userRepository, sectorRepository);
        final UserDTO createdUserDTO = new UserDTO();
        createdUserDTO.setName(REFERENCE_NAME);
        createdUserDTO.setIsAgreed(REFERENCE_AGREED);

        userService.saveUser(createdUserDTO);

        final UserDTO newUserDTO = new UserDTO();
        newUserDTO.setName(REFERENCE_NAME);
        userService.fillUserData(newUserDTO);

        assertEquals(createdUserDTO, newUserDTO);
    }

    private User createUserEntity(final String userName) {
        final User userEntity = userRepository.findByName(userName);
        if (userEntity == null) {
            return new User();
        }

        return userEntity;
    }
}
