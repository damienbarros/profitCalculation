package com.dbprojects.profitCalculation.controller;

import com.dbprojects.profitCalculation.entity.Shipment;
import com.dbprojects.profitCalculation.repository.ShipmentRepository;
import com.dbprojects.profitCalculation.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/system")
@CrossOrigin(origins = "http://localhost:4200")
public class SystemController {

    private final SystemService systemService;
    private final ShipmentRepository shipmentRepository;

    @Autowired
    public SystemController(SystemService systemService, ShipmentRepository shipmentRepository) {
        this.systemService = systemService;
        this.shipmentRepository = shipmentRepository;
    }

    @PostMapping("/calculate")
    public Shipment calculateProfitOrLoss(@RequestBody Shipment shipment) {
        double profitOrLoss = systemService.calculateProfitOrLoss(shipment);
        shipment.setProfitOrLoss(profitOrLoss);
        return shipmentRepository.save(shipment);
    }

    @GetMapping("/id")
    public Optional<Shipment> getShipment(Long id) {
        return shipmentRepository.findById(id);
    }

    @GetMapping("/shipments")
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

}
