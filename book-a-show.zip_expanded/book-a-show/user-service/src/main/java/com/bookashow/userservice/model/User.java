// user-service/src/main/java/com/bookashow/user/entity/User.java
package com.bookashow.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @Email
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    private String email;

    private String role; // e.g., ROLE_USER, ROLE_ADMIN
}
