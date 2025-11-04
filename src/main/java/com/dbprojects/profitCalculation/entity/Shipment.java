package com.dbprojects.profitCalculation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String refShipemnt;
    private List<Customer> customers;
    private List<ServiceProvision> serviceProv;

    public Shipment() {
    }

    public Shipment(int id, String refShipemnt, List<Customer> customers, List<ServiceProvision> serviceProv) {
        this.id = id;
        this.refShipemnt = refShipemnt;
        this.customers = customers;
        this.serviceProv = serviceProv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefShipemnt() {
        return refShipemnt;
    }

    public void setRefShipemnt(String refShipemnt) {
        this.refShipemnt = refShipemnt;
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
