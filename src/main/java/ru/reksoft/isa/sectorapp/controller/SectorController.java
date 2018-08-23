package ru.reksoft.isa.sectorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.reksoft.isa.sectorapp.dto.SectorDTO;
import ru.reksoft.isa.sectorapp.facade.SectorFacade;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;

import java.util.Set;

@RestController
@RequestMapping("/sector")
public class SectorController {
    @Autowired
    SectorRepository repository;

    @PostMapping("/list")
    public Set<SectorDTO> getList() {
        return new SectorFacade(repository).getSectors();
    }
}
