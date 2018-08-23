package ru.reksoft.isa.sectorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SectorRepository.class)
public class Reset {
    public static void main(String[] args) {
        SpringApplication.run(Reset.class, args);
    }
}
