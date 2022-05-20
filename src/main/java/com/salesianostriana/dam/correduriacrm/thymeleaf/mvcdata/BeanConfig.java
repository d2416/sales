package com.salesianostriana.dam.correduriacrm.thymeleaf.mvcdata;

import com.salesianostriana.dam.correduriacrm.thymeleaf.mvcdata.repository.EmailData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public EmailData emailData() {
        EmailData emailData = new EmailData();
        return emailData;
    }
}
