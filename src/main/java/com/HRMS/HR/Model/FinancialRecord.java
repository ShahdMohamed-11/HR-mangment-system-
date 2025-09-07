package com.HRMS.HR.Model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name ="financialrecord")
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "amount")
    private Float amount ;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name="financial_type", nullable = false)
    private FinancialType financialType;

    @Column(name = "assigned_date", nullable = false)
    private LocalDate assignedDate;

    public FinancialRecord(){};

    public FinancialRecord(Float amount, FinancialType financialType ,Employee employee) {
        this.amount = amount;
        this.financialType = financialType;
        this.employee=employee;
        this.assignedDate=LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public FinancialType getFinancialType() {
        return financialType;
    }

    public void setFinancialType(FinancialType financialType) {
        this.financialType = financialType;
    }

}

