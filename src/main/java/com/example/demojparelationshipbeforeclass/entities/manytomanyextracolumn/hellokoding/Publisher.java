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

    public Publisher(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<BookPublisher> bookPublishers = new HashSet<>();



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
