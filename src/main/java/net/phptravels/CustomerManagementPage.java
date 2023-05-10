package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class CustomerManagementPage {
    WebDriver driver= TestApp.getInstance().getDriver();

    PropertyFileReader property= new PropertyFileReader();

    String submitButtonElement = property.getProperty("CustomerManagementPage","submit.button.element");


    public  CustomerCreationPage addCustomer(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(submitButtonElement),
                Duration.ofSeconds(10));
        driver.findElement(By.xpath(submitButtonElement)).click();

        return new CustomerCreationPage();
    }
}
