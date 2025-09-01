package com.HRMS.HR.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "firstname")
    private String firstname ;

    @Column(name = "lastname")
    private String lastname ;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;


    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinancialRecord> financialRecords;


    //attendance
}

