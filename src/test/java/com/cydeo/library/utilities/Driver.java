package com.cydeo.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //By creating a private constructor we are closing the access to the object of this class from outside the class
    private Driver() {
    }

    //We make WebDriver private because we want to close access from outside the class
    // We make is static because we will use it inside static method
    //private static WebDriver driver;//Value is null by default
    private static InheritableThreadLocal<WebDriver>driverPool=new InheritableThreadLocal<>();


    //Create a reusable method which will run same driver instance when we call it
    public static WebDriver getDriver() {
        //It will check if driver is null and if it is we will set up browser inside if statement
        //if you already set up driver and using it again for following line of code it will return to the same driver
        if (driverPool.get() == null) {

            // We read browserType from configuration.properties with the help of
            // ConfigurationReader class's get property method
            String browserType=ConfigurationReader.getProperty("browser");
            switch(browserType){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                    break;
            }

        }
        return driverPool.get();
    }
    public static void closeDriver(){
        if(driverPool.get()!=null){
            driverPool.get().quit();//This line will terminate the existing driver session. After using driver.quit() driver
            // will not be null so, we assign it to null again
            driverPool.remove();
        }
    }
}