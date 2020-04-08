/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * @author Admin
 */
@Named(value = "loanCalculator")
@RequestScoped
public class LoanCalculator implements Serializable {

    /**
     * Creates a new instance of LoanCalculator
     */
    public LoanCalculator() {

    }

    private double monthlyPayment;
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

    private double getMonthlyPayment() {
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
        monthlyPayment = loan.getMonthlyPayment();
        return monthlyPayment;
    }

    public double getTotalPayment() {
        return monthlyPayment * numberOfYears * 12;
    }

    public String getResult() {
        return "Loan Amount: " + loanAmount + "<br />" +
                "Annual Interest Rate: " + annualInterestRate + "<br />" +
                "Number of Years: " + numberOfYears + "<br />" +
                "Monthly Payment: " + getMonthlyPayment() + "<br />" +
                "Total Payment: " + getTotalPayment();
    }

}
