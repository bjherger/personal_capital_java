package trials;

import java.util.Random;

public class Trial {

    public final int numYears;
    public final Double startingBalance;
    public final Double annualInflation;
    public final Double[] standardDeviations;
    public final Double[] annualBalances;
    public final Portfolio[] portfolios;
    private final Random randomGenerator;


    public Trial(int numYears, Double startingBalance, Double annualInflation, Portfolio[] portfolios) {
        this.numYears = numYears;
        this.startingBalance = startingBalance;
        this.annualInflation = annualInflation;
        this.portfolios = portfolios;
        this.standardDeviations = new Double[this.getNumYears()];
        this.annualBalances = new Double[this.getNumYears()];
        this.randomGenerator = new Random();
        this.runTrial();
    }

    public void runTrial(){

        Double current_balance = this.getStartingBalance();

        // Generate standard deviations
        for (int i = 0; i < this.getNumYears(); i++) {
            this.standardDeviations[i] = this.randomGenerator.nextGaussian();
        }


        // Loop through portfolios
        for (Portfolio currentPortfolio : this.portfolios){

            // Loop through years
            for (int i = 0; i < this.numYears; i++) {

            }
        }



        // TODO Check if balance is negative. If so, 'freeze' account

        // TODO If account is not frozen update for this year
        // TODO Compute balance with return

        // TODO Adjust for inflation

        // TODO Update current balance and annualBalances

        // TODO Create TrialResult
    }

    public int getNumYears() {
        return numYears;
    }

    public Double getStartingBalance() {
        return startingBalance;
    }

    public Double getAnnualInflation() {
        return annualInflation;
    }
}
