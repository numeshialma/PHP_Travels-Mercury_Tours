package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerCreation {

    public void setFirstName(WebDriver driver,String firstName){
        waitUntilNextElementAppears(driver,By.name("fname"), Duration.ofSeconds(5));
        driver.findElement(By.name("fname")).sendKeys(firstName);

    }

    public void setLastName(WebDriver driver,String lastName){
        waitUntilNextElementAppears(driver,By.name("lname"),Duration.ofSeconds(5));
        driver.findElement(By.name("lname")).sendKeys(lastName);

    }

    public void setEmail(WebDriver driver,String email){
        waitUntilNextElementAppears(driver,By.name("email"),Duration.ofSeconds(5));
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void setPassword(WebDriver driver,String password){
        waitUntilNextElementAppears(driver, By.name("password"), Duration.ofSeconds(5));
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void setMobile(WebDriver driver,String mobile){
        waitUntilNextElementAppears(driver,By.name("mobile"),Duration.ofSeconds(5));
        driver.findElement(By.name("mobile")).sendKeys(mobile);
    }

    public void setAddress1(WebDriver driver,String address1){
        waitUntilNextElementAppears(driver, By.name("address1"), Duration.ofSeconds(5));
        driver.findElement(By.name("address1")).sendKeys(address1);
    }

    public void setAddress2(WebDriver driver,String address2){
        waitUntilNextElementAppears(driver, By.name("address2"), Duration.ofSeconds(5));
        driver.findElement(By.name("address2")).sendKeys(address2);
    }

    public void selectCountry(WebDriver driver,String country){
        waitUntilNextElementAppears(driver, By.name("country"), Duration.ofSeconds(5));
        Select dropDownCountry = new Select(driver.findElement(By.name("country")));
        dropDownCountry.selectByVisibleText(country);
    }
    public void submit(WebDriver driver){
        waitUntilNextElementAppears(driver, By.xpath("//button[@type='submit']"), Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private WebElement waitUntilNextElementAppears(WebDriver driver, By locator, Duration timeOut){
        WebElement element = new WebDriverWait(driver,timeOut).until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
        return element;
    }
}
