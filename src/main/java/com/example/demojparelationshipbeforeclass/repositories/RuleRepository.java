package com.example.demojparelationshipbeforeclass.repositories;

import com.example.demojparelationshipbeforeclass.entities.dlm.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Integer> {
}
