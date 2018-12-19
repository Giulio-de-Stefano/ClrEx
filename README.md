# ClrEx

Notes:

* I'm using ChromeDriver to run the tests, I have currently hardcoded the path to it in the class World. Please change
it to your local ChromeDriver location. Ideally it would refer a system variable, or be configurable through parameters.
* I found that the expectations for Test 3 are wrong - the test fails on the goal score avg interest and annual cost
* I separated the API test into another project - I don't think it's a good idea to mix the two
* My slider moving implementation works but it's not optimal - it's too slow!
* The browser currently doesn't close after each test. I tried using Cucumber Hooks (@Before/After) but I had some issues
where PicoContainer's World wouldn't be instantiated properly, so I skipped this functionality for the time being.

Answers to questions:

1. I would add a step to the product's CI build in order to:
    * pull the test repository
    * run the test
    * if there's any failure, stop the build
    
2. I never had this problem but I'll take a guess: add randomised time intervals according to how users use the product - 
with a min threshold equalling the average reaction time (~250ms) plus any estimated time before the next action. There should
be a mapping between groups of API calls and user actions, since one user action can trigger multiple API requests.

3. Different browsers can be supported by making the instantiation of the WebDriver configurable at runtime.
Mobile devices can be automated through Appium, preferably using an online cloud testing platform such as TestObject
or BrowserStack rather than doing it locally.