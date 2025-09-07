package com.HRMS.HR.Service;

import com.HRMS.HR.Model.Employee;
import com.HRMS.HR.Model.FinancialRecord;
import com.HRMS.HR.Model.FinancialType;
//import com.HRMS.HR.Model.HR;
import com.HRMS.HR.Repository.EmployeeRepository;
import com.HRMS.HR.Repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialService {

    private final FinancialRecordRepository financialRecordRepository;
    private final EmployeeRepository employeeRepository;


    @Autowired
    public FinancialService(FinancialRecordRepository financialRecordRepository,
                            EmployeeRepository employeeRepository) {
        this.financialRecordRepository = financialRecordRepository;
        this.employeeRepository = employeeRepository;
    }



    public FinancialRecord addFinancialRecord(Long employeeId, Float amount,
                                              FinancialType financialType) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        FinancialRecord record = new FinancialRecord(amount, financialType ,employee);

        employee.addFinancialRecord(record);

        return financialRecordRepository.save(record);
    }



    public List<FinancialRecord> getEmployeeFinancialRecords(Long employeeId) {
        return financialRecordRepository.findByEmployeeId(employeeId);
    }


}
