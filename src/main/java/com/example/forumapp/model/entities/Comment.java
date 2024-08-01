package com.example.forumapp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import static org.hibernate.annotations.CascadeType.MERGE;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private long id;
    private String text;
    @ManyToOne
    @Cascade(MERGE)
    private User author;
    @OneToOne
    @Cascade(MERGE)
    private Post post;
}

