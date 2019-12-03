package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding.dlm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ruleId;



}
