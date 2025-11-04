package com.dbprojects.profitCalculation.service;

import com.dbprojects.profitCalculation.entity.Customer;
import com.dbprojects.profitCalculation.entity.ServiceProvision;
import com.dbprojects.profitCalculation.entity.Shipment;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    //FR1 - handle customer income for each shipment
    public double calculateTotalIncome(Shipment shipment) {
        double total = 0.0;
        for (Customer customer : shipment.getCustomers()) {
            total += customer.getPaymentAmount();
        }
        return total;
    }

    //FR2 - handle all costs related to service provision
    public double calculateTotalCosts(Shipment shipment) {
        double cost = 0.0;
        for (ServiceProvision service : shipment.getServiceProv()) {
            cost += service.getCostAmount();
        }
        return cost;
    }

    //FR3 - calculate the total profit or loss for each shipment
    public double calculateProfitOrLoss(Shipment shipment) {
        double income = calculateTotalIncome(shipment);
        double costs = calculateTotalCosts(shipment);
        double profitOrloss = income - costs;

        shipment.setProfitOrLoss(profitOrloss);
        return profitOrloss;
    }

}
