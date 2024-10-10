package com.security.security.dto;

import com.security.security.entity.Role;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
