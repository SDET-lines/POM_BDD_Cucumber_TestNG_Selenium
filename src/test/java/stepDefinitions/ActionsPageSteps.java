package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DHTMLPage;
import pages.JqueryDblClickPage;
import pages.JqueryTooltipPage;

public class ActionsPageSteps  {

    private final DHTMLPage dhtmlPage;
    private final JqueryDblClickPage jqueryDblClickPage;
    private final JqueryTooltipPage jqueryTooltipPage;

    public ActionsPageSteps (DHTMLPage dhtmlPage, JqueryDblClickPage jqueryDblClickPage,
                             JqueryTooltipPage jqueryTooltipPage ) {
        this.dhtmlPage = dhtmlPage;
        this.jqueryDblClickPage =jqueryDblClickPage;
        this.jqueryTooltipPage = jqueryTooltipPage;    }

    @Given("user navigates to DHTML Page")
    public void navigateToDHTMLPage()  {
        dhtmlPage.navigateToDHTMLPage();
    }

    @When("user should be able to drag and drop capital to its city")
    public void dragAndDropCapitalToItsCity() {
          dhtmlPage.dragAndDropCapitalToItsCity();
    }

    @Then("user verifies drag and drop performed successfully")
    public void user_verifies_drag_and_drop_performed_successfully() {
        Assert.assertTrue(dhtmlPage.getCssValueOslo(),"Color verification failed");
    }

    @Given("navigate to the jquery website")
    public void navigate_to_the_jquery_website() {
       jqueryDblClickPage.navigateToJqueryDblClickPage();
    }

    @When("switch to the iframe")
    public void switch_to_the_iframe() {
        jqueryDblClickPage.switchToTheDemoIframeWithScrolling();
    }

    @When("double click the box")
    public void double_click_the_box() {
       jqueryDblClickPage.doubleClickTheBox();
    }

    @Then("verify the box color is changed")
    public void verify_the_box_color_changed() {
        Assert.assertTrue(jqueryDblClickPage.getCssValueBlock(),"Color verification failed");
    }

    @Given("user navigates to JQuery UI page")
    public void user_navigates_to_j_query_ui_page() {
        jqueryTooltipPage.navigateToJqueryTooltipPage();
    }

    @When("user hovers over the tooltip field")
    public void user_hovers_over_the_tooltip_field() {
        jqueryTooltipPage.switchToTheIframe();
        jqueryTooltipPage.hoverOverTheField();
    }

    @Then("user validates tooltip on JQuery UI Page")
    public void user_validates_tooltip_on_j_query_ui_page() {
        Assert.assertEquals(jqueryTooltipPage.getTextTooltip(), "We ask for your age only for statistical purposes.",
                "Tooltip hover over verification failed");
    }
}
