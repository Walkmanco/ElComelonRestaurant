package com.example.restaurant.Dtos;


import java.util.Set;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class UserRegisterDto {
    private String name;
    private String email;
    private String password; 
    private Set<String> roles; 
}
