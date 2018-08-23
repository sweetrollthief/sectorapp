package ru.reksoft.isa.sectorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.WebApplicationContext;
import ru.reksoft.isa.sectorapp.beans.UserBean;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SectorRepository.class)
public class Reset {

    public static void main(String[] args) {
        SpringApplication.run(Reset.class, args);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserBean userBean() {
        return new UserBean();
    }
}
