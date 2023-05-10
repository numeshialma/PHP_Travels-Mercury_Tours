package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CustomerCreationTest1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.net/api/admin");
        driver.manage().window().maximize();

        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        waitUntilNextElementAppears(By.xpath("//*[@href='javascript:void(0);']"),
                Duration.ofSeconds(10));

        //driver.findElement(By.linkText("Accounts")).click(); //failed
        List<WebElement>menuElementAccount=
                driver.findElements(By.xpath("//*[@href='javascript:void(0);']"));
        menuElementAccount.get(2).click();

        waitUntilNextElementAppears(By.linkText("Customers"),Duration.ofSeconds(5));

        //Thread.sleep(2000);
        driver.findElement(By.linkText("Customers")).click();

        waitUntilNextElementAppears(By.xpath("//button[@type='submit']"),Duration.ofSeconds(10));
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Thread.sleep(3000);
        waitUntilNextElementAppears(By.name("fname"),Duration.ofSeconds(10));

    }

    @Test
    public void testCreateCustomer() throws InterruptedException {
        driver.findElement(By.name("fname")).sendKeys("Imperial");
        driver.findElement(By.name("lname")).sendKeys("College");
        driver.findElement(By.name("email")).sendKeys("info@imperial.lk");
        driver.findElement(By.name("password")).sendKeys("admin@12345");
        driver.findElement(By.name("mobile")).sendKeys("0112889776");
        driver.findElement(By.name("address1")).sendKeys("Borella");
        driver.findElement(By.name("address2")).sendKeys("Colombo");

        Select dropDownCountry = new Select(driver.findElement(By.name("country")));
        dropDownCountry.selectByVisibleText("Hong Kong");
        //Thread.sleep(2000);
        dropDownCountry.selectByValue("LK");
        //Thread.sleep(2000);
        dropDownCountry.selectByIndex(6);
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @AfterMethod
    public void tearDown() {

    }

    private WebElement waitUntilNextElementAppears( By locator, Duration timeOut){
        WebElement element = new WebDriverWait(driver,timeOut).until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
        return element;
    }

}
