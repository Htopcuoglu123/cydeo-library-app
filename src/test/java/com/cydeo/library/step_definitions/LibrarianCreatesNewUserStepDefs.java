package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.UsersModulePage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class LibrarianCreatesNewUserStepDefs {
UsersModulePage usersModulePage=new UsersModulePage();
BasePage basePage=new BasePage();
    @Given("librarian is on the home page")
    public void librarian_is_on_the_home_page() {
       // Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));

    }
    @When("librarian clicks Users module")
    public void librarian_clicks_users_module() throws InterruptedException {
       BrowserUtils.waitFor(5);
       basePage.usersLink.click();

    }
    @When("librarian clicks Add User button")
    public void librarian_clicks_add_user_button() {
       usersModulePage.addNewUser.click();

    }
    @When("librarian enters full name,password, email address")
    public void librarian_enters_full_name_password_email_address() throws InterruptedException {
    usersModulePage.fullNameBox.sendKeys("James Bond");
   // BrowserUtils.waitForClickablility(By.xpath("//input[@type='password']"),10);
        Thread.sleep(3000);
    usersModulePage.passwordBox.sendKeys("JB123");
   // BrowserUtils.waitForClickablility(By.xpath("//input[@placeholder='Email']"),10);
        Thread.sleep(3000);
    usersModulePage.emailBox.sendKeys("JBond@gmail.com");
   // BrowserUtils.waitForClickablility(By.xpath("//button[@type='submit']"),10);
    Thread.sleep(3000);
    usersModulePage.saveChangesBtn.click();
    }
    @When("librarian clicks save changes")
    public void librarian_clicks_save_changes() {

    }
    @Then("verify a new user is created")
    public void verify_a_new_user_is_created() {

    }

}
