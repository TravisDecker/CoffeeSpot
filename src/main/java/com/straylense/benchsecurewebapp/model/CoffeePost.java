package com.straylense.benchsecurewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private Long postId;


    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime dateTimePosted;

    @NonNull
    private String postBody;

    //Make this flexible, maybe we want to add reactions (IE facebook). Maybe a hash map?
    @OneToMany
    List<User> likes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Comment> comments = new ArrayList<>();

}
