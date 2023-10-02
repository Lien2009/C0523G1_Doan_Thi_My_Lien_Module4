package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", unique = true)
    private String title;
    @Column(columnDefinition = "text")
    @NotEmpty(message = "Không để trống!")
    private String content;
    private String author;
    @Column(columnDefinition = "date")
    private String time;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String content, String author, String time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
    }

    public Blog(int id, String title, String content, String author, String time, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTime() {
        return time;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
