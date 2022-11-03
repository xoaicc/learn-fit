package com.example.restfulapi2.repository;

import com.example.restfulapi2.entity.Company;
import com.example.restfulapi2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
