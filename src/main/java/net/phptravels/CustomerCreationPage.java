package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class CustomerCreationPage {
    WebDriver driver = TestApp.getInstance().getDriver();

    PropertyFileReader property = new PropertyFileReader();

    String firstNameElement = property.getProperty("CustomerCreationPage","first.name.element");
    String lastNameElement = property.getProperty("CustomerCreationPage" ,"last.name.element");
    String emailElement = property.getProperty("CustomerCreationPage","email.element");
    String emailPasswordElement = property.getProperty("CustomerCreationPage", "email.password.element");
    String mobileElement = property.getProperty("CustomerCreationPage","mobile.element");
    String address1Element = property.getProperty("CustomerCreationPage","address1.element");
    String address2Element = property.getProperty("CustomerCreationPage","address2.element");
    String countryElement = property.getProperty("CustomerCreationPage","country.element");
    String submit1ButtonElement = property.getProperty("CustomerCreationPage","submit1.button.element");


    public CustomerCreationPage setFirstName(String firstName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(firstNameElement),
                Duration.ofSeconds(5));
        driver.findElement(By.name(firstNameElement)).sendKeys(firstName);

        return this;
    }

    public CustomerCreationPage setLastName(String lastName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(lastNameElement),
                Duration.ofSeconds(5));
        driver.findElement(By.name(lastNameElement)).sendKeys(lastName);

        return this;
    }

    public CustomerCreationPage setEmail(String email){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(emailElement),
                Duration.ofSeconds(5));
        driver.findElement(By.name(emailElement)).sendKeys(email);

        return this;
    }

    public CustomerCreationPage setPassword(String password){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(emailPasswordElement),
                Duration.ofSeconds(5));
        driver.findElement(By.name(emailPasswordElement)).sendKeys(password);

        return this;
    }

    public CustomerCreationPage setMobile(String mobileNo){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(mobileElement),
                Duration.ofSeconds(5));
        driver.findElement(By.name(mobileElement)).sendKeys(mobileNo);

        return this;
    }


    public CustomerCreationPage selectCountry(String countryName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(countryElement),
                Duration.ofSeconds(5));
        Select dropDownCountry = new Select(driver.findElement(By.name(countryElement)));
        dropDownCountry.selectByVisibleText(countryName);

        return this;
    }

    public CustomerCreationPage setAddress1(String addressOne){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(address1Element),
                Duration.ofSeconds(5));
        driver.findElement(By.name(address1Element)).sendKeys(addressOne);

        return this;
    }

    public CustomerCreationPage setAddress2(String addressTwo){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(address2Element),
                Duration.ofSeconds(5));
        driver.findElement(By.name(address2Element)).sendKeys(addressTwo);

        return this;
    }

    public CustomerManagementPage submit(){
            TestApp.getInstance().waitUntilNextElementAppears(By.xpath(submit1ButtonElement),
                    Duration.ofSeconds(5));
        driver.findElement(By.xpath(submit1ButtonElement)).click();

        return new CustomerManagementPage();
    }
}
