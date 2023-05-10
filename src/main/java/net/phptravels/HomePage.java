package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver = TestApp.getInstance().getDriver();
    PropertyFileReader property= new PropertyFileReader();
    String accountMenuElement = property.getProperty("HomePage", "accounts.menu.element");
    String customerMenuElement = property.getProperty("HomePage","customer.menu.element");

    public HomePage selectAccountMenu(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(accountMenuElement),
                Duration.ofSeconds(10));
        List<WebElement> menuElementAccount=
                driver.findElements(By.xpath(accountMenuElement));
        menuElementAccount.get(2).click();

        return this;
    }

    public CustomerManagementPage selectCustomerMenu(){
        TestApp.getInstance().waitUntilNextElementAppears(By.linkText(customerMenuElement),
                Duration.ofSeconds(10));
        driver.findElement(By.linkText(customerMenuElement)).click();

        return new CustomerManagementPage();
    }
}
