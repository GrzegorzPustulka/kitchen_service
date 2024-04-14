package com.kitchen.controller;


import com.kitchen.dto.user.EmployeeCreationDTO;
import com.kitchen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public void createEmployee(@RequestBody EmployeeCreationDTO employeeCreationDTO) {
        employeeService.createEmployee(employeeCreationDTO);
    }

}
