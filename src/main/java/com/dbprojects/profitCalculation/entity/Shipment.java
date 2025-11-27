package com.dbprojects.profitCalculation.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "shipment_number")
    private String shipmentNumber;
    @Column(name = "profit_or_loss")
    double profitOrLoss;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Customer> customers;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ServiceProvision> serviceProv;


    public Shipment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public double getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<ServiceProvision> getServiceProv() {
        return serviceProv;
    }

    public void setServiceProv(List<ServiceProvision> serviceProv) {
        this.serviceProv = serviceProv;
    }
}
