package trials;

public class TrialResult {

    public final int numYears;
    public final Double startingBalance;
    public final Double annualInflation;
    public final Portfolio portfolio;
    public final Double[] annualBalances;
    public final Double endingBalance;

    @Override
    public String toString() {
        return "TrialResult{" +
                ", portfolio=" + portfolio +
                ", endingBalance=" + endingBalance +
                '}';
    }

    public TrialResult(int numYears, Double startingBalance, Double annualInflation, Portfolio portfolio, Double[] annualBalances) {
        this.numYears = numYears;
        this.startingBalance = startingBalance;
        this.annualInflation = annualInflation;
        this.portfolio = portfolio;
        this.annualBalances = annualBalances;
        this.endingBalance = annualBalances[annualBalances.length -1];
    }
}
