package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class BookPublisher implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    private Date publishedDate;

    public BookPublisher() {
    }

    public BookPublisher(Book book) {
        this.book = book;
    }

    public BookPublisher(Publisher publisher, Date publishedDate) {
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookPublisher)) return false;
        BookPublisher that = (BookPublisher) o;
        return Objects.equals(book.getTitle(), that.book.getTitle()) &&
                Objects.equals(publisher.getName(), that.publisher.getName()) &&
                Objects.equals(publishedDate, that.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book.getTitle(), publisher.getName(), publishedDate);
    }
}
