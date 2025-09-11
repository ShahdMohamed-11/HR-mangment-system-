package com.HRMS.HR.Service;

import com.HRMS.HR.Model.Employee;
import com.HRMS.HR.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {

    private final EmployeeRepository employeeRepository;

    public GeneralService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
