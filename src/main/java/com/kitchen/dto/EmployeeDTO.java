package com.kitchen.dto;

import com.kitchen.model.User;
import com.kitchen.model.UserAddress;
import com.kitchen.model.UserDetails;

import java.util.UUID;

public class EmployeeDTO {

    private UUID id;
    private User user;
    private UserAddress userAddress;

    private UserDetails userDetails;

    public EmployeeDTO(User user, UserAddress userAddress, UserDetails userDetails) {
        this.id = user.getId();
        this.user = user;
        this.userAddress = userAddress;
        this.userDetails = userDetails;
    }
}
