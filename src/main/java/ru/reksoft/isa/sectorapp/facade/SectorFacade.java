package ru.reksoft.isa.sectorapp.facade;

import ru.reksoft.isa.sectorapp.entity.Sector;
import ru.reksoft.isa.sectorapp.dto.SectorDTO;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;

import java.util.*;

public class SectorFacade {
    final private SectorRepository repository;

    public SectorFacade(final SectorRepository repository) {
        this.repository = repository;
    }



    private static void reduceSector(final Map<Integer, Set<SectorDTO>> mapping, final Sector sector) {
        final int parentId = sector.getParent();
        Set<SectorDTO> currentSet = mapping.get(parentId);

        if (currentSet == null) {
            currentSet= new HashSet<>();
            mapping.put(parentId, currentSet);
        }

        final SectorDTO sectorDTO = new SectorDTO();
        sectorDTO.setId(sector.getId());
        sectorDTO.setLabel(sector.getLabel());

        currentSet.add(sectorDTO);
    }

    private static void reduceParent(final Map<Integer, Set<SectorDTO>> mapping, final SectorDTO sector) {
        final int sectorId = sector.getId();
        final Set<SectorDTO> children = mapping.remove(sectorId);
        if (children != null) {
            sector.setChildren(children);
            children.stream().forEach(x -> reduceParent(mapping, x));
        }
    }

    public Set<SectorDTO> getSectors() {
        final Map<Integer, Set<SectorDTO>> sectorMapping = new HashMap<>();
        repository.findAll().forEach(x -> reduceSector(sectorMapping, x));

        final Set<SectorDTO> rootSectors = sectorMapping.remove(0);
        rootSectors.stream().forEach(x -> reduceParent(sectorMapping, x));

        return rootSectors;
    }
}
