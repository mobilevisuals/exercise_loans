/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
@Named(value = "loanCalculator")
@SessionScoped
public class LoanCalculator implements Serializable {

    /**
     * Creates a new instance of LoanCalculator
     */
    public LoanCalculator() {
    }

    private double loanAmount;
    private double annualInterestRate;
    private int numberOfYears;

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void clear() {
        annualInterestRate = 0;
        numberOfYears = 0;
        loanAmount = 0;
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        return  loanAmount * monthlyInterestRate / (1
                - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    public String getResult() {
        return "Loan Amount: " + loanAmount + "<br />" +
                "Annual Interest Rate: " + annualInterestRate + "<br />" +
                "Number of Years: " + numberOfYears + "<br />" +
                "Monthly Payment: " + getMonthlyPayment() + "<br />" +
                "Total Payment: " + getTotalPayment();
    }

}
