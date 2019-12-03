package com.example.demojparelationshipbeforeclass;

import com.example.demojparelationshipbeforeclass.entities.manytoone.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class MainRestController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/meme")
    public List<Employee> getEmp() {

        return entityManager.createQuery("select e from Employee e")
                .getResultList();
    }
}
