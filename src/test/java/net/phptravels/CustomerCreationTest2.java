package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerCreationTest2 {
    WebDriver driver;
    Login login;
    Home home;
    CustomerManagement customerManagement;
    CustomerCreation customerCreation;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.net/api/admin");
        driver.manage().window().maximize();

        login = new Login();
        login.loginAs(driver,"admin@phptravels.com","demoadmin");

        home = new Home();
        home.selectAccountMenu(driver);
        home.selectCustomerMenu(driver);

        customerManagement = new CustomerManagement();
        customerManagement.addCustomer(driver);

    }

    @Test
    public void testCustomerCreation() {
        customerCreation= new CustomerCreation();

        customerCreation.setFirstName(driver,"Roy");
        customerCreation.setLastName(driver,"Don");
        customerCreation.setEmail(driver,"Roy@hotmail.com");
        customerCreation.setPassword(driver,"Admin@12345");
        customerCreation.setMobile(driver,"0112532145");
        customerCreation.setAddress1(driver,"40th Lane Marine Drive");
        customerCreation.setAddress2(driver,"Colombo 06");
        customerCreation.selectCountry(driver,"France");
        customerCreation.submit(driver);
    }
}
