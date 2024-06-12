package com.kodilla.hibernate.manytomany.controller;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/byPrefix")
    public List<Company> getCompaniesByPrefix(@RequestParam String prefix) {
        return companyRepository.findByFirstThreeLettersOfName(prefix);
    }
}
