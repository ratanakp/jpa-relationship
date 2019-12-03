package com.example.demojparelationshipbeforeclass;

//import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone.Post;
//import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone.PostTag;
//import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone.Tag;
import com.example.demojparelationshipbeforeclass.entities.manytoone.Department;
import com.example.demojparelationshipbeforeclass.entities.manytoone.Employee;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

@SpringBootApplication
@Transactional
public class DemoJpaRelationshipBeforeClassApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaRelationshipBeforeClassApplication.class, args);

    }

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Department department = new Department("IT");
        Employee employee = new Employee("home", "male", 100, department);

        entityManager.persist(employee);
        /*
        *
        * TODO: Many-To-Many
        *
        * */

        /*Product product = new Product("COCA");
        Product product1 = new Product("Fanta");

        List<Product> products = Arrays.asList(product, product1);

        Customer customer = new Customer("name");
        customer.setProducts(products);

//        entityManager.persist(product);
//        entityManager.persist(product1);

        entityManager.persist(customer);*/



        /*
         *
         * TODO: Many-TO-Many Extra column simpleone
         *
         * */
        /*Tag tag = new Tag("news");
        tag = tagRepository.save(tag);

        Post post = new Post("Post Title");

        post = postRepository.save(post);

        PostTag postTag = new PostTag(post, tag, "Pu Nak");
        postTag = postTagRepository.save(postTag);*/

    }
}
