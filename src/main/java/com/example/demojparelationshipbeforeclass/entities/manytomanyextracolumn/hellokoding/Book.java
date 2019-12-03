package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookPublisher> bookPublishers;

    public Book(String title, BookPublisher... bookPublishers) {
        this.title = title;
        for(BookPublisher bookPublisher : bookPublishers) bookPublisher.setBook(this);
        this.bookPublishers = Stream.of(bookPublishers).collect(Collectors.toSet());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Set<BookPublisher> getBookPublishers() {
        return bookPublishers;
    }

    public void setBookPublishers(Set<BookPublisher> bookPublishers) {
        this.bookPublishers = bookPublishers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", bookPublishers=" + bookPublishers +
                '}';
    }
}
