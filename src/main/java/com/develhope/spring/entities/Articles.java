package com.develhope.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    private List<String> tags;

    @Column(nullable = false, length = 5000)
    private String text;

    @Column(nullable = false)
    private Date postingDate;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false,unique = true)
    private String author;

//    @OneToOne
//    private User user;





}
