package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import userInterface.common.PlaywrightDriver;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MercuryToursStepDef {

    @Given("user enters {string} & {string}")
    public void user_enters(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("somwthing here ");
        PlaywrightDriver.getPage().navigate(PlaywrightDriver.config.getProperty("testsiteurl"));
        System.out.println(PlaywrightDriver.getPage().title());
        PlaywrightDriver.getPage().locator("//input[@name='userName']").fill("mercury");
        PlaywrightDriver.getPage().locator("//input[@name='password']").fill("mercury");
        PlaywrightDriver.getPage().locator("//input[@name='submit']").click();
    }
    @And("checks if mercury site home page is displayed with success message as {string}")
    public void checks_if_mercury_site_home_page_is_diaplayed_with_success_message_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("somwthing here ");
        System.out.println(PlaywrightDriver.getPage().locator("//h3[text()='Login Successfully']").innerText());
        assertThat(PlaywrightDriver.getPage().locator("//h3[text()='Login Successfully']")).hasText("Login Successfully");

    }


}
