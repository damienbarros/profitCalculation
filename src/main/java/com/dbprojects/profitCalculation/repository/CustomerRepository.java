package com.dbprojects.profitCalculation.repository;

import com.dbprojects.profitCalculation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
