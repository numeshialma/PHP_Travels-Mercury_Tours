package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class LoginPage {
    WebDriver driver = TestApp.getInstance().getDriver();

    PropertyFileReader property = new PropertyFileReader();
    String userNameElement = property.getProperty("LoginPage", "user.name.element");
    String passwordElement = property.getProperty("LoginPage","password.element");
    String loginButtonElement = property.getProperty("LoginPage", "login.button.element");


    public HomePage loginSuccess(String userName, String password){
        /*
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

         */

        loginAs(userName,password);
        return new HomePage();
    }

    public LoginPage loginUnSuccess(String userName, String password){
        /*
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

         */
        loginAs(userName,password);
        return this;
    }

    private void loginAs(String userName, String password){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(userNameElement),
                Duration.ofSeconds(10));
        driver.findElement(By.name(userNameElement)).sendKeys(userName);

        driver.findElement(By.name(passwordElement)).sendKeys(password);

        driver.findElement(By.xpath(loginButtonElement)).click();

    }
}
