package com.dbprojects.profitCalculation.DTO;

public class ProfitUpdateRequest {

    private double profitOrLoss;

    public ProfitUpdateRequest() {

    }

    public double getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }
}
