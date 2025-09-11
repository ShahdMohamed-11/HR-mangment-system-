package com.HRMS.HR.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "TOemployee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> TOtasks;

    @OneToMany(mappedBy = "FROMemployee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> FROMtasks;


    public Employee(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        financialRecords = new ArrayList<>();
        TOtasks = new ArrayList<>();
        FROMtasks = new ArrayList<>();
    }

    public long getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<FinancialRecord> getFinancialRecords() {
        return financialRecords;
    }

    public void setFinancialRecords(List<FinancialRecord> financialRecords) {
        this.financialRecords = financialRecords;
    }

    public void addFinancialRecord(FinancialRecord record) {
        financialRecords.add(record);
        record.setEmployee(this);
    }

    public List<Task> getTOtasks() {
        return TOtasks;
    }

    public List<Task> getFROMtasks() {
        return FROMtasks;
    }

    public void addTask(Task newtask , Employee to) {
        FROMtasks.add(newtask);
        newtask.setFROMemployee(this);
        newtask.setTOemployee(to);
    }

//attendance
}

