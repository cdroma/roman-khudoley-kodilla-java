package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CompanyDaoTestSuite1 {
    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    void cleanUP() {
        companyRepository.deleteAll();
    }

    @Test
    @DisplayName("Finding company by first 3 letters")
    void testFindByFirstThreeLettersOfName() {
        // Given
        Company company1 = new Company("Microlife");
        Company company2 = new Company("IBM");
        Company company3 = new Company("Microsoft");
        companyRepository.save(company1);
        companyRepository.save(company2);
        companyRepository.save(company3);

        // When
        List<Company> companies = companyRepository.findByFirstThreeLettersOfName("Mic");

        // Then
        assertEquals(2, companies.size());
        assertTrue(companies.stream().anyMatch(c -> c.getName().equals("Microlife")));
        assertTrue(companies.stream().anyMatch(c -> c.getName().equals("Microsoft")));
    }
}
