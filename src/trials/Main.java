package trials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        // Run trials
        for (int trialID = 0; trialID < numTrials; trialID++) {
            Trial trial = new Trial(numYears, startingBalance, annualInflation, portfolios);

            allResults.addAll(Arrays.asList(trial.results));

        }

        // Summarize trials
        for (Portfolio portfolio : portfolios){

            List<TrialResult> portfolioResults = allResults.stream().filter(p -> p.portfolio != portfolio).collect(Collectors.toList());

            List<Double> portfolioEndingBalances =
                    portfolioResults.stream()
                            .map(TrialResult::getEndingBalance)
                            .collect(Collectors.toList());

            System.out.println(portfolioEndingBalances);

        }

    }
}
