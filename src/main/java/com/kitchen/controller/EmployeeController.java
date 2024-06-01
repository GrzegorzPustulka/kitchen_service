package com.kitchen.controller;


import com.kitchen.dto.employee.EmployeeCreationDTO;
import com.kitchen.dto.employee.EmployeeLoginDTO;
import com.kitchen.model.User;
import com.kitchen.service.EmployeeService;
import com.kitchen.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody EmployeeLoginDTO loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = employeeService.getUserByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

            String jwt = jwtUtil.generateToken(String.valueOf(user.getId()), String.valueOf(user.getRole()));
            Map<String, String> response = new HashMap<>();
            response.put("jwt", jwt);
            response.put("userId", String.valueOf(user.getId()));
            response.put("userType", String.valueOf(user.getRole()));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public void createEmployee(@RequestBody EmployeeCreationDTO employeeCreationDTO) {
        employeeService.createEmployee(employeeCreationDTO);
    }

}
