package stepdef;

import io.cucumber.java.en.Given;
import userInterface.common.PlaywrightDriver;

public class FrameworkStepDef {
    @Given("user launch the mercury website")
    public void userLaunchTheMercuryWebsite() {
        System.out.println("inside background");
        PlaywrightDriver.setupDriver();



    }
}
