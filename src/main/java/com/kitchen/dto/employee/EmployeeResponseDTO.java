package com.kitchen.dto.employee;

import com.kitchen.enums.UserAddressType;
import com.kitchen.enums.UserRoleType;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class EmployeeResponseDTO {

    private UUID id;
    private String email;
    private UserRoleType role;

    // UserDetails fields
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date birthDate;

    // UserAddress fields
    private Set<AddressDTO> addresses;

    public static class AddressDTO {
        private String country;
        private String city;
        private String street;
        private String zipCode;
        private String houseNumber;
        private int apartmentNumber;
        private UserAddressType type;

        // Getters and setters
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

        public int getApartmentNumber() {
            return apartmentNumber;
        }

        public void setApartmentNumber(int apartmentNumber) {
            this.apartmentNumber = apartmentNumber;
        }

        public UserAddressType getType() {
            return type;
        }

        public void setType(UserAddressType type) {
            this.type = type;
        }
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleType getRole() {
        return role;
    }

    public void setRole(UserRoleType role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
