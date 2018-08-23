package ru.reksoft.isa.sectorapp;

import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import ru.reksoft.isa.sectorapp.bean.UserBean;

@Configuration
@ComponentScan(basePackages = {"ru.reksoft.isa.sectorapp"})
public class AppConfig {
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserBean userBean() {
        return new UserBean();
    }
}
