package net.phptravels;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class CustomerCreationTest4 {

    LoginPage loginPage;
    HomePage homePage;
    CustomerManagementPage customerManagementPage;
    CustomerCreationPage customerCreationPage;

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();

        loginPage = new LoginPage();
        homePage=loginPage.loginSuccess("admin@phptravels.com","demoadmin");

        homePage.selectAccountMenu().selectCustomerMenu();

        customerManagementPage = homePage.selectAccountMenu().selectCustomerMenu();

        customerCreationPage = customerManagementPage.addCustomer();

    }

    @Test
    public void testCustomerCreation() {
        customerManagementPage = customerCreationPage
                .setFirstName("Imperial")
                .setLastName("College")
                .setEmail("info@imperialcollege.com")
                .setPassword("admin@123")
                .setMobile("011288767")
                .selectCountry("Finland")
                .setAddress1("Borella")
                .setAddress2("Colombo")
                .submit();
    }
}
