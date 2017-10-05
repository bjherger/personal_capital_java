package trials;

import java.util.Random;

public class Trial {

    public final int numYears;
    public final Double startingBalance;
    public final Double annualInflation;
    public final Double[] standardDeviations;
    public final Portfolio[] portfolios;
    public final TrialResult[] results;
    private final Random randomGenerator;


    public Trial(int numYears, Double startingBalance, Double annualInflation, Portfolio[] portfolios) {
        this.numYears = numYears;
        this.startingBalance = startingBalance;
        this.annualInflation = annualInflation;
        this.portfolios = portfolios;
        this.standardDeviations = new Double[this.numYears];
        this.randomGenerator = new Random();
        this.results = this.runTrial();
    }

    public TrialResult[] runTrial(){

        // Reference variables
        TrialResult[] results = new TrialResult[2];

        // Generate standard deviations
        for (int year = 0; year < this.numYears; year++) {
            this.standardDeviations[year] = this.randomGenerator.nextGaussian();
        }


        // Loop through portfolios

        for (int currentPortfolioIndex = 0; currentPortfolioIndex < portfolios.length; currentPortfolioIndex++) {
            Portfolio currentPortfolio = portfolios[currentPortfolioIndex];
            // Set up variables for current run
            Double currentBalance = this.startingBalance;
            Double[] annualBalances = new Double[this.numYears];

            // Loop through years
            for (int year = 0; year < this.numYears; year++) {

                // Check if balance is negative. If so, 'freeze' account
                if (currentBalance <= 0){
                    continue;
                }

                // If account is not frozen, update for this year
                else {

                    Double nextBalance;

                    // Compute balance with return
                    Double returnPercentage = standardDeviations[year]* currentPortfolio.getReturnVar() + currentPortfolio.getReturnMean();
                    nextBalance = currentBalance * (1 + returnPercentage);

                    // Adjust for inflation
                    nextBalance = nextBalance * (1+ this.annualInflation);

                    // Update current balance and annualBalances
                    currentBalance = nextBalance;
                    annualBalances[year] = currentBalance;


                }
            }
            // Create TrialResult
            results[currentPortfolioIndex] = new TrialResult(this.numYears, this.startingBalance, this.annualInflation, currentPortfolio, annualBalances);
        }
        return results;
    }

}
