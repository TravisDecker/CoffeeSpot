package com.straylense.benchsecurewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NonNull
    @Column(unique = true)
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    private String firstName;

    private String lastName;

    @Column(columnDefinition = "varchar(255) default 'ROLE_USER'")
    @Builder.Default
    private String roles = "ROLE_USER";

    @OneToMany
    List<User> friends = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<CoffeePost> posts = new LinkedList<>();

    @Column(columnDefinition = "boolean default true")
    @Builder.Default
    private boolean enabled = true;

    @Column(columnDefinition = "boolean default true")
    @Builder.Default
    private boolean isAccountNonExpired = true;

    @Column(columnDefinition = "boolean default true")
    @Builder.Default
    private boolean isAccountNonLocked = true;

    @Column(columnDefinition = "boolean default true")
    @Builder.Default
    private boolean isCredentialsNonExpired = true;

}
