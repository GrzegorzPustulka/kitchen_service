package com.kitchen.service;

import com.kitchen.dto.employee.EmployeeCreationDTO;
import com.kitchen.dto.employee.EmployeeResponseDTO;
import com.kitchen.enums.UserAddressType;
import com.kitchen.enums.UserRoleType;
import com.kitchen.model.User;
import com.kitchen.model.UserAddress;
import com.kitchen.model.UserDetails;
import com.kitchen.repository.user.EmployeeRepository;
import com.kitchen.repository.user.EmployeeAddressRepository;
import com.kitchen.repository.user.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmailGeneratorService emailGeneratorService;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final EmployeeAddressRepository employeeAddressRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmailGeneratorService emailGeneratorService, PasswordEncoder passwordEncoder, EmployeeDetailsRepository employeeDetailsRepository, EmployeeAddressRepository employeeAddressRepository) {
        this.employeeRepository = employeeRepository;
        this.emailGeneratorService = emailGeneratorService;
        this.passwordEncoder = passwordEncoder;
        this.employeeDetailsRepository = employeeDetailsRepository;
        this.employeeAddressRepository = employeeAddressRepository;
    }

    @Transactional
    public void createEmployee(EmployeeCreationDTO employeeCreationDTO) {
        User employee = new User();

        employee.setId(UUID.randomUUID());
        employee.setRole(UserRoleType.PERSONAL);
        employee.setPassword(passwordEncoder.encode(employeeCreationDTO.getPassword()));
        employee.setEmail(emailGeneratorService.generateEmail(employeeCreationDTO.getFirstName(), employeeCreationDTO.getLastName()));
        employee = employeeRepository.save(employee);

        UserDetails employeeDetails = new UserDetails();
        employeeDetails.setUser(employee);
        employeeDetails.setId(UUID.randomUUID());
        employeeDetails.setFirstName(employeeCreationDTO.getFirstName());
        employeeDetails.setLastName(employeeCreationDTO.getLastName());
        employeeDetails.setPhoneNumber(employeeCreationDTO.getPhoneNumber());
        employeeDetails.setEmail(employee.getEmail());
        employeeDetailsRepository.save(employeeDetails);

        UserAddress employeeAddress = new UserAddress();
        employeeAddress.setUser(employee);
        employeeAddress.setId(UUID.randomUUID());
        employeeAddress.setApartmentNumber(employeeCreationDTO.getApartmentNumber());
        employeeAddress.setCountry(employeeCreationDTO.getCountry());
        employeeAddress.setHouseNumber(employeeCreationDTO.getHouseNumber());
        employeeAddress.setStreet(employeeCreationDTO.getStreet());
        employeeAddress.setCity(employeeCreationDTO.getCity());
        employeeAddress.setZipCode(employeeCreationDTO.getZipCode());
        employeeAddress.setType(UserAddressType.RESIDENCE);
        employeeAddressRepository.save(employeeAddress);

    }

    public Optional<User> getUserByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Optional<EmployeeResponseDTO> getUserById(UUID userId) {
        return employeeRepository.findById(userId).map(this::convertToEmployeeResponseDTO);
    }

    public EmployeeResponseDTO convertToEmployeeResponseDTO(User user) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());

        UserDetails userDetails = user.getUserDetails();
        if (userDetails != null) {
            dto.setFirstName(userDetails.getFirstName());
            dto.setLastName(userDetails.getLastName());
            dto.setPhoneNumber(userDetails.getPhoneNumber());
            dto.setBirthDate(userDetails.getBirthDate());
        }

        Set<EmployeeResponseDTO.AddressDTO> userAddressDTOs = user.getUserAddress().stream().map(address -> {
            EmployeeResponseDTO.AddressDTO userAddressDTO = new EmployeeResponseDTO.AddressDTO();
            userAddressDTO.setCountry(address.getCountry());
            userAddressDTO.setCity(address.getCity());
            userAddressDTO.setStreet(address.getStreet());
            userAddressDTO.setZipCode(address.getZipCode());
            userAddressDTO.setHouseNumber(address.getHouseNumber());
            userAddressDTO.setApartmentNumber(address.getApartmentNumber());
            userAddressDTO.setType(address.getType());
            return userAddressDTO;
        }).collect(Collectors.toSet());
        dto.setAddresses(userAddressDTOs);

        return dto;
    }

}
