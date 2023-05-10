package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyFileReader;

import java.util.List;

public class LoginTest {

    PropertyFileReader prop= new PropertyFileReader();
    String url = prop.getProperty("config","url");

    @Test                           //open the browser
    public void testLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get(url);

        driver.manage().window().maximize();

        WebElement txtEmailElement = driver.findElement(By.name("email"));
        txtEmailElement.sendKeys("admin@phptravels.com");
        txtEmailElement.clear();

        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        List<WebElement>message=
                driver.findElements(By.xpath("//*[text()='Dashboard']"));
        String actualHomePageMessage=message.get(2).getText();

        Assert.assertEquals(actualHomePageMessage,"Dashboard","Failed to Login");

        driver.findElement(By.id("dropdownMenuProfile")).click();
        Thread.sleep(2000);

        //driver.findElement(By.linkText("Logout")).click(); //failed
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        driver.quit();
        //driver.close();

    }
}
