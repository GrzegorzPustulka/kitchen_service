package com.kitchen.repository;

import com.kitchen.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<User, String> {

    @EntityGraph(attributePaths = {"userDetails", "userAddresses"})
    User findById(String id);
}