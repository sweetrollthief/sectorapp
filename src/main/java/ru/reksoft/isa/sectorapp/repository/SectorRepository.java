package ru.reksoft.isa.sectorapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.reksoft.isa.sectorapp.entity.Sector;

@Repository
public interface SectorRepository extends CrudRepository<Sector, Integer> {
}
