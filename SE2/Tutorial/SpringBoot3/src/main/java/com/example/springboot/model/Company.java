package com.example.springboot.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 3, max = 30)
    private String name;

    @NotEmpty
    private String image;

    @Length(min = 5, max = 50)
    private String address;
}
