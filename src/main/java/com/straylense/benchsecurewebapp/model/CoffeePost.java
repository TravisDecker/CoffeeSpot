package com.straylense.benchsecurewebapp.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "post")
public class CoffeePost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID postId;

    @NonNull
    @ManyToOne
    private User user;

    @NonNull
    private String postBody;

    private int likes = 0;

}
