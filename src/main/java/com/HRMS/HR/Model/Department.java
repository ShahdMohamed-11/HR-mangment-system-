package com.HRMS.HR.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "description")
    private String description ;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
}
