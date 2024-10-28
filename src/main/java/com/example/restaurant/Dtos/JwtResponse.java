package com.example.restaurant.Dtos;


import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String email, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.email = email;
    this.roles = roles;
  }
  
}
