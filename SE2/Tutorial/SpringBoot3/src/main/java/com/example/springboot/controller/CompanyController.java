package com.example.springboot.controller;

import com.example.springboot.model.Company;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.CompanyRepository;
import com.example.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public String getCompanyById(@PathVariable(value = "id") Long id, Model model) {
        Company company = companyRepository.getById(id);
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("company", company);
        return "companyDetail";
    }
}
