package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersModulePage extends BasePage{
    public UsersModulePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(partialLinkText =" Add User")
    WebElement addUserBtn;

    @FindBy(name = "full_name")
    WebElement fullNameBox;

    @FindBy(name = "password")
    WebElement passwordBox;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveChangesBtn;

}
