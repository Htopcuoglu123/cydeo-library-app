package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void setUpScenario(Scenario scenario) throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        LoginPage loginPage=new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
        String username=ConfigurationReader.getProperty("lib32_user");
        String password=ConfigurationReader.getProperty("lib32_pass");

        loginPage.login(username,password);

    }

    @After//After method is coming from cucumber.java and, it runs after each scenario
    public void tearDownScenario(Scenario scenario){
        System.out.println("-->It is coming from @After in Hooks");


        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            //We store bytes of our screenshots in  byte array
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }
}
