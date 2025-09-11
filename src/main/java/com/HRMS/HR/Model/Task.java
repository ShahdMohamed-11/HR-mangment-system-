package com.HRMS.HR.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;


    @ManyToOne
    @JoinColumn(name = "to_employee_id", referencedColumnName = "id", nullable = false)
    private Employee TOemployee;

    @ManyToOne
    @JoinColumn(name = "from_employee_id", referencedColumnName = "id", nullable = false)
    private Employee FROMemployee;


    @Column(name = "evaluation")
    private int evaluation;


    @Column(name = "status")
    private boolean status;

    public Employee getTOemployee() {
        return TOemployee;
    }

    public void setTOemployee(Employee TOemployee) {
        this.TOemployee = TOemployee;
    }

    public Employee getFROMemployee() {
        return FROMemployee;
    }

    public void setFROMemployee(Employee FROMemployee) {
        this.FROMemployee = FROMemployee;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "description")
    private String description;


}
