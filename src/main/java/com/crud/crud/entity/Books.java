package com.crud.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books", schema = "dev_projects")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBooks")
    public Long idBooks;
    @Column(name="title")
    public String title;
    @Column(name="description")
    public String description;
    @Column(name="published")
    public Boolean published = true;
}