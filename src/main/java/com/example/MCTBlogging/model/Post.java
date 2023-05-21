package com.example.MCTBlogging.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_table")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @NotBlank(message = "Name of post should be provided")
    @Column(name = "postname")
    private String postName;
    @NotBlank(message = "Description should be provided for better experience")
    @Column(name = "description")
    private String postDescription;
    @Column(name = "createddate")
    private Timestamp createdDate;

    @Column(name = "views")
    private int views;
    @Column(name = "likes")
    private int likes;
}
