package com.example.demojparelationshipbeforeclass.entities.onetoone;


import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String gender;
    private double salary;

    @OneToOne
    private ParkingSpace parkingSpace;

    public Employee() {
    }

    public Employee(String fullName, String gender, double salary) {
        this.fullName = fullName;
        this.gender = gender;
        this.salary = salary;
    }

    public Employee(String fullName, String gender, double salary, ParkingSpace parkingSpace) {
        this.fullName = fullName;
        this.gender = gender;
        this.salary = salary;
        this.parkingSpace = parkingSpace;
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

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", parkingSpace=" + parkingSpace +
                '}';
    }
}
