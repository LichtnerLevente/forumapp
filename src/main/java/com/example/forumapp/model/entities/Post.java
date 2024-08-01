package com.example.forumapp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

import static org.hibernate.annotations.CascadeType.MERGE;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;

    @OneToMany
    @Cascade(MERGE)
    private Set<Comment> comments;
}
