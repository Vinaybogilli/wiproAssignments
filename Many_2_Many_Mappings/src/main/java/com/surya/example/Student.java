package com.surya.example;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
    		mappedBy="user",
    		cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subjects> post;

    public Student() {
    }

    public Student(Long id, String name, List<Subjects> post) {
        this.id = id;
        this.name = name;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subjects> getPost() {
        return post;
    }

    public void setPost(List<Subjects> post) {
        this.post = post;
    }
}
