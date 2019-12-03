package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Publisher() {
    }

    public Publisher(int id, Set<BookPublisher> bookPublishers) {
        this.id = id;
        this.bookPublishers = bookPublishers;
    }

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<BookPublisher> bookPublishers = new HashSet<>();

    public Publisher(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookPublisher> getBookPublishers() {
        return bookPublishers;
    }

    public void setBookPublishers(Set<BookPublisher> bookPublishers) {
        this.bookPublishers = bookPublishers;
    }
}
