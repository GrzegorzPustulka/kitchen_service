package com.kitchen.repository.user;

import com.kitchen.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeAddressRepository extends JpaRepository<UserAddress, UUID> {
}
