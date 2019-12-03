package com.example.demojparelationshipbeforeclass.entities.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(targetEntity = Product.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "cus_pro",
            joinColumns = @JoinColumn(name = "cus_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pro_id", referencedColumnName = "id")

    )
    private List<Product> products;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
