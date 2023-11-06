package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.IFramePage;
import pages.NestedFramesPage;

public class IFramesPageSteps extends BasePage {

    private final IFramePage iFramesPage;
    private final NestedFramesPage nestedFramesPage;

    public IFramesPageSteps (IFramePage iFramesPage, NestedFramesPage nestedFramesPage) {
        this.iFramesPage=iFramesPage;
        this.nestedFramesPage=nestedFramesPage;
    }

    @Given("user navigates to iFrame page")
    public void user_navigates_to_iFrame_page() {
        iFramesPage.navigateToIFramePage();
    }

    @When("user enters {int} symbols of random text into the text box on iFrame Page")
    public void user_enters_symbols_of_random_text_into_the_text_box_on_i_frame_page(int length) {
       iFramesPage.setSpecifiedQuantityOfRandomText(length);
    }

    @Then("user verifies the entered text on iFrames Page")
    public void user_verifies_the_entered_text_on_i_frames_page() {
        Assert.assertEquals(iFramesPage.getRandomTextToEnter(), iFramesPage.getTextEntered(),
                "Entered text verification failed");
    }

    @Given("user navigates to the Nested Frames page")
    public void userNavigatesToTheNestedFramesPage() {
        nestedFramesPage.navigateToNestedFramesPage();
    }

    @Then("user should be able to verify the text {string} in the left frame")
    public void user_should_be_able_to_verify_the_text_in_the_left_frame(String string) {
        nestedFramesPage.switchToLeftFrame();
        Assert.assertEquals(nestedFramesPage.getFrameText(), string,"Text verification in the left frame failed");
    }
}
