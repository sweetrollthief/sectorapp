package ru.reksoft.isa.sectorapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.reksoft.isa.sectorapp.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.name = ?1")
    User findByName(final String userName);
}
