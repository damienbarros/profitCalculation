package com.dbprojects.profitCalculation.repository;

import com.dbprojects.profitCalculation.entity.ServiceProvision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProvisionRepository extends JpaRepository<ServiceProvision, Long> {
}
