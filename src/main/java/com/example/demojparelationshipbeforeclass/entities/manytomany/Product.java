package com.example.demojparelationshipbeforeclass.entities.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String proName;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    private List<Customer> customers;

    public Product() {
    }

    public Product(String proName) {
        this.proName = proName;
    }

    public Product(String proName, List<Customer> customers) {
        this.proName = proName;
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", customers=" + customers +
                '}';
    }
}
