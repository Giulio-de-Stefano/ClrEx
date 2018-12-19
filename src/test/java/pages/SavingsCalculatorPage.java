package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavingsCalculatorPage extends PageAB {

    public SavingsCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "js-range-current")
    public WebElement currentScoreSlider;
    public int currentScoreStartValue = 380; // could be read programmatically but assigning constant values for time reasons

    @FindBy(className = "js-range-goal")
    public WebElement goalScoreSlider;
    public int goalScoreStartValue = 450;

    public int commonScoreMinValue = 0;
    public int commonScoreMaxValue = 700;

    @FindBy(className = "js-current-average-rate")
    public WebElement currentAvgRate;

    @FindBy(className = "js-current-annual-cost")
    public WebElement currentAnnualCost;

    @FindBy(className = "js-current-cc-available")
    public WebElement currentCCAvailable;

    @FindBy(className = "js-goal-average-rate")
    public WebElement goalAvgRate;

    @FindBy(className = "js-goal-annual-cost")
    public WebElement goalAnnualCost;

    @FindBy(className = "js-goal-cc-available")
    public WebElement goalCCAvailable;

    @FindBy(className = "js-total-saving-value")
    public WebElement totalSavingValue;

    @Override
    public String getUrl() {
        return super.getUrl() + "/savings-calculator";
    }

    public void updateCurrentScoreSliderTo(int toValue) {
        moveSlider(currentScoreSlider, currentScoreStartValue, toValue);
    }

    public void updateGoalScoreSliderTo(int toValue) {
        moveSlider(goalScoreSlider, goalScoreStartValue, toValue);
    }

    private void validateSliderInput(int value, int minValue, int maxValue) {
        if (value < minValue || value > maxValue)
            throw new IllegalArgumentException("The wanted slider value [" + value
                    + "] should be between [" + minValue + "] and [" + maxValue + "]");
    }

    // This would end up in a Helper class if I had the need to automate sliders in other pages
    private void moveSlider(WebElement slider, int startValue, int toValue) {
        validateSliderInput(toValue, commonScoreMinValue, commonScoreMaxValue);

        /*
        I tried the Actions solution but had a hard time getting it to work - the slider was moving but unpredictably
        There might be a little math to do about width and/or pixels to figure out how the input translates to movement
        Using a for with sleeps isn't elegant and it's pretty slow... but at least it works
        */

//        Actions move = new Actions(driver);
//        move.dragAndDropBy(currentScoreSlider, -10, 0).perform();

        Keys movementKey;

        if (toValue >= startValue)
            movementKey = Keys.ARROW_RIGHT;
        else
            movementKey = Keys.ARROW_LEFT;

        int movementDifference = Math.abs(toValue - startValue);

        for (int i = 0; i < movementDifference; i++) {
            slider.sendKeys(movementKey);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}