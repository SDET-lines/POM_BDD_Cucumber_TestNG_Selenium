package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.IFramePage;
import pages.NestedFramesPage;

public class IFramesPageSteps  {

    private final IFramePage iFramesPage;
    private final NestedFramesPage nestedFramesPage;

    public IFramesPageSteps (IFramePage iFramesPage, NestedFramesPage nestedFramesPage) {
        this.iFramesPage=iFramesPage;
        this.nestedFramesPage=nestedFramesPage;
    }

    @Given("user navigates to iFrame page")
    public void navigateToIFramePage() {
        iFramesPage.navigateToIFramePage();
    }

    @When("user enters {int} symbols of random text into the text box on iFrame Page")
    public void enterSymbolsOfRandomText(int length) {
       iFramesPage.setSpecifiedQuantityOfRandomText(length);
    }

    @Then("user verifies the entered text on iFrames Page")
    public void verifyEnteredText() {
        String actualText = iFramesPage.getTextEntered();
        String expectedText = iFramesPage.getRandomTextToEnter();
        Assert.assertEquals(actualText, expectedText,"Entered text verification failed");
    }

    @Given("user navigates to the Nested Frames page")
    public void navigateToNestedFramesPage() {
        nestedFramesPage.navigateToNestedFramesPage();
    }

    @Then("user should be able to verify the text {string} in the left frame")
    public void verifyTextInLeftFrame(String expectedText) {
        nestedFramesPage.switchToLeftFrame();
        String actualText = nestedFramesPage.getFrameText();
        Assert.assertEquals(actualText, expectedText,"Text verification in the left frame failed");
    }
}
