package com.dbprojects.profitCalculation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String refShipemnt;
    double profitOrLoss;

    @OneToMany(mappedBy = "shipment", cascade = cascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers;

    @OneToMany(mappedBy = "shipment", cascade = cascadeType.ALL, orphanRemoval = true)
    private List<ServiceProvision> serviceProv;


    public Shipment() {
    }

    public Shipment(Long id, String refShipemnt, double profitOrLoss, List<Customer> customers, List<ServiceProvision> serviceProv) {
        this.id = id;
        this.refShipemnt = refShipemnt;
        this.profitOrLoss = profitOrLoss;
        this.customers = customers;
        this.serviceProv = serviceProv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefShipemnt() {
        return refShipemnt;
    }

    public void setRefShipemnt(String refShipemnt) {
        this.refShipemnt = refShipemnt;
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
