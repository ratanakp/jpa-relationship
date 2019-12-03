package com.example.demojparelationshipbeforeclass.entities.manytoone;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String gender;
    private double salary;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String fullName, String gender, double salary) {
        this.fullName = fullName;
        this.gender = gender;
        this.salary = salary;
    }

    public Employee(String fullName, String gender, double salary, Department department) {
        this.fullName = fullName;
        this.gender = gender;
        this.salary = salary;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
