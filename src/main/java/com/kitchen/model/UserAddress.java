package com.kitchen.model;


import com.kitchen.enums.UserAddressType;
import com.kitchen.enums.UserRoleType;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Name("userAddress")
@Getter
@Setter
@NoArgsConstructor
@ToString
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
    private int houseNumber;

    @Column(name = "apartment_number")
    private int apartmentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserAddressType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UserAddress(String country, String city, String street, String zipCode, int houseNumber, int apartmentNumber, UserAddressType type) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.type = type;
    }

}
