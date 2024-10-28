package com.example.restaurant.Servicios;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.restaurant.Entidades.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data

public class UserDetailsImpl implements  UserDetails{
  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;
  private String username;

  private String email;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;
  
  public UserDetailsImpl(Long id, String email, String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;    
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }


    public static UserDetailsImpl build(Usuario user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(),                
        user.getCorreo(),
        user.getContrasena(), 
        authorities);
  }

    
}
