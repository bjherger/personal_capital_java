package trials;

public class Portfolio {

    private final String portfolio_name;
    private final double returnMean;
    private final double returnVar;

    public Portfolio(String portfolio_name, double returnMean, double returnVar) {
        this.portfolio_name = portfolio_name;

        this.returnMean = returnMean;
        this.returnVar = returnVar;
    }

    @Override
    public String toString() {
        String self_string = String.format("<portfolio_name: %s, returnMean: %f, returnVariance: %f>",
                this.getPortfolio_name(), this.getReturnMean(), this.getReturnVar());
        return self_string;
    }

    public String getPortfolio_name() {
        return portfolio_name;
    }

    public double getReturnMean() {
        return returnMean;
    }

    public double getReturnVar() {
        return returnVar;
    }
}
