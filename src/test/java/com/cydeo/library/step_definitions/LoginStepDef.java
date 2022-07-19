package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDef {
    LandingPage landingPage=new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
        BrowserUtils.waitFor(5);
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
        loginPage.signInButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expected = "dashboard";

        wait.until(ExpectedConditions.urlContains("dashboard"));
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue("Dashboard does not appear on URL", Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("student55_user"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("student55_pass"));
        loginPage.signInButton.click();

    }

    @Then("books should be displayed")
    public void books_should_be_displayed() {
        wait.until(ExpectedConditions.urlContains("books"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("books"));
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {

        loginPage.emailInput.sendKeys(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInButton.click();
    }

//    @When("there should be {string} users")
//    public void there_should_be_users(String expectedUserCount) {
//        BrowserUtils.waitForVisibility(landingPage.userCount,5);
//        String actualUserCount=landingPage.userCount.getText();
//        Assert.assertEquals("Usercount is failing",expectedUserCount,actualUserCount);
//    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int expectedUserNum) {
        //String expectedUserCount=expectedUserNum+"";
        String expectedUserCount=String.valueOf(expectedUserNum);
        BrowserUtils.waitForVisibility(landingPage.userCount,5);
        String actualUserCount=landingPage.userCount.getText();
        Assert.assertEquals("Usercount is failing",expectedUserCount,actualUserCount);
    }
    @When("I login using {string} and {string}")
    public void i_login_using_and(String email, String password) {
    loginPage.emailInput.sendKeys(email);
    loginPage.passwordInput.sendKeys(password);
    loginPage.signInButton.click();
    }
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedUserName) {
    String actualUserName=landingPage.userNameLink.getText();
    Assert.assertEquals("UserNameText verification Failed",expectedUserName,actualUserName);
    }


}