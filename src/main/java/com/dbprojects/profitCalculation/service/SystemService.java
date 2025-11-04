package com.dbprojects.profitCalculation.service;

import com.dbprojects.profitCalculation.entity.Customer;
import com.dbprojects.profitCalculation.entity.ServiceProvision;
import com.dbprojects.profitCalculation.entity.Shipment;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    //FR1 - handle customer income for each shipment
    public double calculateIncome(Shipment shipment) {
        double income = 0.0;
        for (Customer c : shipment.getCustomers()) {
            income += c.getPaymentAmount();
        }
        return income;
    }

    //FR2 - handle all costs related to service provision
    public double calculateCosts(Shipment shipment) {
        double cost = 0.0;
        for (ServiceProvision s : shipment.getServiceProv()) {
            cost += s.getCostAmount();
        }
        return cost;
    }

}
