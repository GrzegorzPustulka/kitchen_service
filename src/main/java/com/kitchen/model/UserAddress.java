package com.kitchen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kitchen.enums.UserAddressType;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Name("userAddress")
@Data
@JsonIgnoreProperties("user") // to avoid infinite recursion
public class UserAddress extends Base{

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "apartment_number")
    private int apartmentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserAddressType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    private User user;

}
