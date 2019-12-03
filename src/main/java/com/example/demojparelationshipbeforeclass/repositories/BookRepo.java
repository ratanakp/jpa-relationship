package com.example.demojparelationshipbeforeclass.repositories;

import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {


}
