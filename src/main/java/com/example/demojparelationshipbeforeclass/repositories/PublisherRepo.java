package com.example.demojparelationshipbeforeclass.repositories;

import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {


}
