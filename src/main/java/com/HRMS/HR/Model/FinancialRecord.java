package com.HRMS.HR.Model;

import jakarta.persistence.*;

public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "amount")
    private Float amount ;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;


}

enum FinancialType {
    BASIC_SALARY,
    BONUS,
    DEDUCTION,
    ALLOWANCE
}
