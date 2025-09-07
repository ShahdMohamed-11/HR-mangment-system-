package com.HRMS.HR.Repository;

import com.HRMS.HR.Model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
    List<FinancialRecord> findByEmployeeId(Long employeeId);
}
