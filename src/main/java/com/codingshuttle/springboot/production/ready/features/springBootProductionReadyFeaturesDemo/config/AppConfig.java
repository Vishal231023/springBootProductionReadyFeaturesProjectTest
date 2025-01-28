package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.config;

import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAware")
public class AppConfig {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getAuditorAware(){
        return new AuditorAwareImpl();
    }
}
