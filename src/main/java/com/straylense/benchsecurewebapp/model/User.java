package com.straylense.benchsecurewebapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @NonNull
    @Column(unique = true)
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    private String firstName;

    private String lastName;

    private String roles;

    @OneToMany
    List<User> friends;

    @Column(columnDefinition = "boolean default true")
    private boolean enabled;

    @Column(columnDefinition = "boolean default true")
    private boolean isAccountNonExpired;

    @Column(columnDefinition = "boolean default true")
    private boolean isAccountNonLocked;

    @Column(columnDefinition = "boolean default true")
    private boolean isCredentialsNonExpired;

}
