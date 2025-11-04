package com.dbprojects.profitCalculation.repository;

import com.dbprojects.profitCalculation.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
