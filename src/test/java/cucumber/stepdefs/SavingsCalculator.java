package cucumber.stepdefs;

import cucumber.World;
import cucumber.api.java8.En;

public class SavingsCalculator implements En {

    public SavingsCalculator(World world) {
        When("^I update my current score to (\\d+)$", (Integer wantedCurrentScore) -> {
            world.savingsCalculatorPage.updateCurrentScoreSliderTo(wantedCurrentScore);
        });

        And("^I update my goal score to (\\d+)$", (Integer wantedGoalScore) -> {
            world.savingsCalculatorPage.updateGoalScoreSliderTo(wantedGoalScore);
        });
    }

}
