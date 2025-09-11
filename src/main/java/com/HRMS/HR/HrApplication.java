package com.HRMS.HR;

import com.HRMS.HR.Model.Department;
import com.HRMS.HR.Model.Employee;
import com.HRMS.HR.Repository.EmployeeRepository;
import com.HRMS.HR.Service.GeneralService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

    @Bean
    CommandLineRunner run(EmployeeRepository employeeRepository) {
        return args -> {
            System.out.println("hello world");
            Employee newemp = new Employee("ramy" , "elsayed","ramm", "4236");
            employeeRepository.save(newemp);
            System.out.println("Employee saved!");
        };
    }

}
