package com.example.springboot.repository;

import com.example.springboot.model.Company;
import com.example.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
