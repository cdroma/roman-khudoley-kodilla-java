package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyEmployeeFacadeTest {

    @Autowired
    private CompanyEmployeeFacade facade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testFindCompaniesByNameFragment() {
        // Given
        Company company1 = new Company("Software Machine");
        Company company2 = new Company("Data Maesters");
        Company company3 = new Company("Grey Matter");
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        // When
        List<Company> result = facade.findCompaniesByNameFragment("Ma");

        // Then
        assertEquals(3, result.size());

        // CleanUp
        companyDao.deleteAll();
    }

    @Test
    void testFindEmployeesByNameFragment() {
        // Given
        Employee employee1 = new Employee("John", "Doe");
        Employee employee2 = new Employee("Jane", "Smith");
        Employee employee3 = new Employee("Eve", "Johnson");
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        // When
        List<Employee> result = facade.findEmployeesByNameFragment("Smi");

        // Then
        assertEquals(1, result.size());
        assertEquals("Smith", result.get(0).getLastname());

        // CleanUp
        employeeDao.deleteAll();
    }
}