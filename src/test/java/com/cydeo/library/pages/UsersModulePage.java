package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersModulePage extends BasePage{
    public UsersModulePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
