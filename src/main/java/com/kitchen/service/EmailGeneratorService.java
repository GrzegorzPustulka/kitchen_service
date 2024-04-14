package com.kitchen.service;

import com.kitchen.repository.user.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.regex.Pattern;

@Service
public class EmailGeneratorService {

    private final EmployeeRepository userRepository;

    public EmailGeneratorService(EmployeeRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateEmail(String firstName, String lastName) {
        // Usunięcie polskich znaków i innych znaków specjalnych
        String normalizedFirstName = normalizeString(firstName);
        String normalizedLastName = normalizeString(lastName);

        String emailBase = normalizedLastName + "." + normalizedFirstName;
        String email = emailBase + "@Dinestream.com";
        int counter = 1;

        // Sprawdzenie, czy email już istnieje
        while (userRepository.existsByEmail(email)) {
            email = emailBase + counter + "@Dinestream.com";
            counter++;
        }

        return email;
    }

    private String normalizeString(String input) {
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "");
    }
}