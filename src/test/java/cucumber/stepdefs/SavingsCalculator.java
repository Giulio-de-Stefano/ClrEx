package cucumber.stepdefs;

import cucumber.World;
import cucumber.api.java8.En;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class SavingsCalculator implements En {

    public SavingsCalculator(World world) {
        When("^I update my current score to (\\d+)$", (Integer wantedCurrentScore) -> {
            world.savingsCalculatorPage.updateCurrentScoreSliderTo(wantedCurrentScore);
        });

        And("^I update my goal score to (\\d+)$", (Integer wantedGoalScore) -> {
            world.savingsCalculatorPage.updateGoalScoreSliderTo(wantedGoalScore);
        });

        Then("^the current score average interest is (\\d+\\.*\\d*%)$", (String expInterestPct) -> {
            assertEquals(world.savingsCalculatorPage.currentAvgRate.getText(), expInterestPct);
        });

        And("^the current annual cost is (\\d+) GBP$", (Integer expAnnualCost) -> {
            assertEquals(world.savingsCalculatorPage.currentAnnualCost.getText(), "£" + expAnnualCost);
        });

        And("^the current number of cards available is (\\d+)$", (Integer expAvailableCardsCount) -> {
            assertEquals(world.savingsCalculatorPage.currentCCAvailable.getText(), expAvailableCardsCount + "");
        });

        And("^the goal score average interest is (\\d+\\.*\\d*%)$", (String expInterestPct) -> {
            assertEquals(world.savingsCalculatorPage.goalAvgRate.getText(), expInterestPct);
        });

        And("^the goal annual cost is (\\d+) GBP$", (Integer expAnnualCost) -> {
            assertEquals(world.savingsCalculatorPage.goalAnnualCost.getText(), "£" + expAnnualCost);
        });

        And("^the goal number of cards available is (\\d+)$", (Integer expAvailableCardsCount) -> {
            assertEquals(world.savingsCalculatorPage.goalCCAvailable.getText(), expAvailableCardsCount + "");
        });

        And("^the potential savings are (\\d+) GBP$", (Integer expPotentialSavings) -> {
            assertEquals(world.savingsCalculatorPage.totalSavingValue.getText(), expPotentialSavings + "");
        });

    }

}
