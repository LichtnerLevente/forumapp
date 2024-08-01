package com.example.forumapp.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewPostDTO {
    private String title;
    private String description;
    private long authorID;

}
