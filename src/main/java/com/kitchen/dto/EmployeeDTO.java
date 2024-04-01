package com.kitchen.dto;

import com.kitchen.model.User;
import com.kitchen.model.UserAddress;
import com.kitchen.model.UserDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Setter
@Getter
public class EmployeeDTO {

    private User user;

    public EmployeeDTO(User user) {
        this.user = user;
    }
}
