package com.kitchen.model;

import com.kitchen.enums.UserRoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor // for hibernate to be able to instantiate the class
public class User extends Base{

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private UserRoleType role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserAddress> userAddress = new HashSet<>();

    // I can't use Lombok's @ToString because it will cause infinite recursion
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
