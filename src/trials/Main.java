package trials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // Variables
        int numTrials = 10000;
        int numYears = 20;
        Double startingBalance = 100000.00;
        Double annualInflation = .035;


        // Set up portfolios
        Portfolio[] portfolios = new Portfolio[2];
        portfolios[0] = new Portfolio("agressive", .094324, .15675);
        portfolios[1] = new Portfolio("very_conservative", .06189, .063438);

        List<TrialResult> allResults = new ArrayList<TrialResult>();


        for (int trialID = 0; trialID < numTrials; trialID++) {
            Trial trial = new Trial(numYears, startingBalance, annualInflation, portfolios);

            allResults.addAll(Arrays.asList(trial.results));

        }

        System.out.println(allResults);

    }
}
