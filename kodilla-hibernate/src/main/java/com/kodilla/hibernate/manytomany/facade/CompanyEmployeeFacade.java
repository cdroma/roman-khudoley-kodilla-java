package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyEmployeeFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompaniesByNameFragment(String fragment) {
        String searchPattern = "%" + fragment + "%";
        return companyDao.findByNameContaining(searchPattern);
    }

    public List<Employee> findEmployeesByNameFragment(String fragment) {
        String searchPattern = "%" + fragment + "%";
        return employeeDao.findByLastNameContaining(searchPattern);
    }
}
