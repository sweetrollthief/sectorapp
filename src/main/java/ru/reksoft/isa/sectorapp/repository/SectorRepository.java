package ru.reksoft.isa.sectorapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.reksoft.isa.sectorapp.dao.Sector;

@Repository
public interface SectorRepository extends CrudRepository<Sector, Integer> {
    @Query("SELECT s FROM Sector s WHERE s.id = ?1")
    Sector findById(final String id);
}
