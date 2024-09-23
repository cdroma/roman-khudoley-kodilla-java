package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class CompanyEmployeeFacade {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Company> findCompaniesByNameFragment(String fragment) {
        String searchPattern = "%" + fragment + "%";
        TypedQuery<Company> query = entityManager.createNamedQuery("Company.findByNameFragment", Company.class);
        query.setParameter("NAME", searchPattern);
        return query.getResultList();
    }

    public List<Employee> findEmployeesByNameFragment(String fragment) {
        String searchPattern = "%" + fragment + "%";
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByLastNameFragment", Employee.class);
        query.setParameter("lastNameFragment", searchPattern);
        return query.getResultList();
    }
}
