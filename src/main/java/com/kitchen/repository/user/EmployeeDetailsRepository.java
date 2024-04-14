package com.kitchen.repository.user;

import com.kitchen.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeDetailsRepository extends JpaRepository<UserDetails, UUID> {
}
