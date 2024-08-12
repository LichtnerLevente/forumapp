package com.example.forumapp.model.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder
@Table(name = "app_user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Post> posts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Comment> comments;

}
