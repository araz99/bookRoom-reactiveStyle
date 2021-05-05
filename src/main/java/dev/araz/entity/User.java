package dev.araz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Set;

@Data
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private int quantityBook;
    @Transient
    private Set<Role> roles;
}
