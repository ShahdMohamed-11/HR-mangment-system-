package com.HRMS.HR.Repository;

import com.HRMS.HR.Model.Employee;
import com.HRMS.HR.Model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByemployeeid(long employeeID);
}
