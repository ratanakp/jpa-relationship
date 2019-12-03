package com.example.demojparelationshipbeforeclass;

//import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone.Post;
//import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone.PostTag;
//import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone.Tag;

import com.example.demojparelationshipbeforeclass.entities.dlm.BaseRule;
import com.example.demojparelationshipbeforeclass.entities.dlm.Rule;
import com.example.demojparelationshipbeforeclass.entities.dlm.RuleBaseRuleR;
import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding.Book;
import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding.BookPublisher;
import com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.hellokoding.Publisher;
import com.example.demojparelationshipbeforeclass.entities.manytoone.Department;
import com.example.demojparelationshipbeforeclass.entities.manytoone.Employee;
import com.example.demojparelationshipbeforeclass.repositories.BaseRuleRepository;
import com.example.demojparelationshipbeforeclass.repositories.BookRepo;
import com.example.demojparelationshipbeforeclass.repositories.PublisherRepo;
import com.example.demojparelationshipbeforeclass.repositories.RuleRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@Transactional
public class DemoJpaRelationshipBeforeClassApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaRelationshipBeforeClassApplication.class, args);

    }

    @PersistenceContext
    private EntityManager entityManager;

    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;
    private RuleRepository ruleRepository;
    private BaseRuleRepository baseRuleRepository;

    public DemoJpaRelationshipBeforeClassApplication(BookRepo bookRepo, PublisherRepo publisherRepo,
                                                     RuleRepository ruleRepository, BaseRuleRepository baseRuleRepository) {
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
        this.ruleRepository = ruleRepository;
        this.baseRuleRepository = baseRuleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Department department = new Department("IT");
        Employee employee = new Employee("home", "male", 100, department);

        entityManager.persist(employee);


        Book book = new Book("Harry Potter");
        Publisher publisher = new Publisher("JK Rowling");

        Publisher publisherA = new Publisher("Publisher A");
        Publisher publisherB = new Publisher("Publisher B");
        publisherRepo.saveAll(Arrays.asList(publisherA, publisherB));

        BookPublisher bookPublisherA = new BookPublisher(publisherA, new Date());
        BookPublisher bookPublisherB = new BookPublisher(publisherB, new Date());

        Book book1 = new Book("Book 1", bookPublisherA, bookPublisherB);

        bookRepo.save(book1);
        bookRepo.save(new Book("Book 2", new BookPublisher(publisherA, new Date())));


        BaseRule baseRule1 = new BaseRule("base rule nm 1", 10, 20,
                "desc", "memo", new Date(), "1001", new Date(), "1002");

        BaseRule baseRule2 = new BaseRule("base rule nm 2", 10, 20,
                "desc", "memo", new Date(), "1001", new Date(), "1002");

        BaseRule baseRule3 = new BaseRule("base rule nm 3", 10, 20,
                "desc", "memo", new Date(), "1001", new Date(), "1002");

        this.baseRuleRepository.saveAll(Arrays.asList(baseRule1, baseRule2, baseRule3));

        RuleBaseRuleR ruleBaseRuleR1 = new RuleBaseRuleR(baseRule1, new Date(), "Meme 1", new Date(), "ok 1");
        RuleBaseRuleR ruleBaseRuleR2 = new RuleBaseRuleR(baseRule2, new Date(), "Meme 2", new Date(), "ok 2");

        Rule rule1 = new Rule("Rule NM", 20, 30, "DESC", "MEMO",
                new Date(), "REGR ID", new Date(), "MODR ID",
                ruleBaseRuleR1, ruleBaseRuleR2);

        this.ruleRepository.save(rule1);



































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
