package com.kitchen.controller;


import com.kitchen.dto.EmployeeDTO;
import com.kitchen.dto.UserUpdateRequest;
import com.kitchen.model.User;
import com.kitchen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable String employeeId) {
         return employeeService.getEmployee(employeeId);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable String employeeId, @RequestBody UserUpdateRequest request) {
        return employeeService.updateEmployee(employeeId, request);
    }

}
