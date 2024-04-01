package com.kitchen.service;

import com.kitchen.dto.EmployeeDTO;
import com.kitchen.dto.UserUpdateRequest;
import com.kitchen.model.User;
import com.kitchen.model.UserAddress;
import com.kitchen.model.UserDetails;
import com.kitchen.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployee(String employeeId){
        Optional<User> employee = employeeRepository.findById(UUID.fromString(employeeId));

        if (employee.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }
        return new EmployeeDTO(employee.get());
    }

    // TODO: Implement the updateEmployee method
    public EmployeeDTO updateEmployee(String employeeId, UserUpdateRequest request){
        Optional<User> employee = employeeRepository.findById(UUID.fromString(employeeId));

        if (employee.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }


    }

}
