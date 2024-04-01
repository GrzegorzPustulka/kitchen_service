package com.kitchen.service;

import com.kitchen.dto.EmployeeDTO;
import com.kitchen.model.User;
import com.kitchen.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployee(String employeeId){
        User user = employeeRepository.findById(employeeId);
    }

}
