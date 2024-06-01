package com.kitchen.dto.employee;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeCreationDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date birthDate;
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;
    private Integer apartmentNumber;
    private String country;
}
