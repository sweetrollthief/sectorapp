package ru.reksoft.isa.sectorapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.reksoft.isa.sectorapp.entity.User;
import ru.reksoft.isa.sectorapp.repository.UserRepository;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestPropertySource(locations="classpath:test.properties")
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testEntity() {
        final String referenceName = "dummyName";
        final boolean referenceBoolean = false;

        final User createdUserEntity = new User();
        createdUserEntity.setName(referenceName);
        createdUserEntity.setIsAgreed(referenceBoolean);

        userRepository.save(createdUserEntity);

        final User loadedUserEntity = userRepository.findByName(referenceName);

        assertEquals(loadedUserEntity.getName(), referenceName);
        assertEquals(loadedUserEntity.getIsAgreed(), referenceBoolean);
    }
}
