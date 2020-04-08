
public class Loan implements java.io.Serializable {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;

    /**
     * Construct a loan with specified annual interest rate,
     * number of years and loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        // Monthly interest rate
        //      // is the yearly rate divided by 12
        double monthlyRate = annualInterestRate / 1200;
// The length of the term in months
        // is the number of years times 12

        int termInMonths = numberOfYears * 12;
        double monthlyPayment =
                (loanAmount * monthlyRate) /
                        (1 - Math.pow(1 + monthlyRate, -termInMonths));
        return monthlyPayment;
    }


}
