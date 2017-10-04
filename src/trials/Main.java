package trials;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    // Variables
        int numTrials = 10000;
        int numYears = 20;
        Double startingAmount = 100000.00;
        Double annualInflation = .035;


        // Set up portfolios
        Portfolio[] portfolioArray = new Portfolio[2];
        portfolioArray[0] = new Portfolio("agressive", .094324, .15675);
        portfolioArray[1] = new Portfolio("very_conservative", .06189, .063438);
        System.out.println("Portfolios: " + Arrays.toString(portfolioArray));


    }
}
