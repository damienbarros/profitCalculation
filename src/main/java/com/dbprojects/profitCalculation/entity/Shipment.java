package com.dbprojects.profitCalculation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reference_number")
    private String refShipment;
    @Column(name = "profit_or_loss")
    double profitOrLoss;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceProvision> serviceProv;


    public Shipment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefShipment() {
        return refShipment;
    }

    public void setRefShipment(String refShipemnt) {
        this.refShipment = refShipment;
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
