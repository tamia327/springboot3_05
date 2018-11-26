package com.example.springboot3_05;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String realname;
    @ManyToMany(mappedBy = "course")
    private Set<course> courses;


}
