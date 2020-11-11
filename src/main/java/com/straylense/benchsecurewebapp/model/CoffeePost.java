package com.straylense.benchsecurewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
public class CoffeePost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID postId;

    private LocalDateTime dateTimePosted;

    @NonNull
    private String postBody;

    private int likes = 0;

}
