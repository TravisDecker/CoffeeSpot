package com.straylense.benchsecurewebapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "post")
public class CoffeePost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID postId;

    //TODO does this work?
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime dateTimePosted;

    @NonNull
    @ManyToOne
    private User user;

    @NonNull
    private String postBody;

    private int likes = 0;

}
