package com.example.restaurant.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean(name = "DefaultMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    
}
