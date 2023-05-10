package net.phptravels;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class CustomerCreationTest3 {
    LoginPage loginPage;
    HomePage homePage;
    CustomerManagementPage customerManagementPage;
    CustomerCreationPage customerCreationPage;

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();

        loginPage = new LoginPage();
        loginPage.loginSuccess("admin@phptravels.com","demoadmin");

        homePage = new HomePage();
        homePage.selectAccountMenu();
        homePage.selectCustomerMenu();

        customerManagementPage=new CustomerManagementPage();
        customerManagementPage.addCustomer();

        customerCreationPage =new CustomerCreationPage();

    }

    @Test
    public void testCustomerCreation() {
        customerCreationPage.setFirstName("Imperial");
        customerCreationPage.setLastName("Collage");
        customerCreationPage.setEmail("info@imperialcollege.lk");
        customerCreationPage.setPassword("admin@123");
        customerCreationPage.setMobile("011288767");
        customerCreationPage.setAddress1("Borella");
        customerCreationPage.setAddress2("Colombo");
        customerCreationPage.selectCountry("Finland");
        customerCreationPage.submit();
    }


}
