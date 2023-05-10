package com.guru99.demo;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class RegisterUserTest {

    HomePage homePage;
    RegisterPage registerPage;
    RegisterSuccessPage regSuccessPage;

    @BeforeMethod
    public void setUp() {

        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        homePage = PageFactory.initElements(TestApp.getInstance().getDriver(),
                HomePage.class);
        registerPage = homePage.selectRegisterMenu();

    }

    @Test
    public void testRegisterNewUser() {

        String firstName = "Oxford";
        String lastName = "College";

        regSuccessPage = registerPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhone("012345677")
                .setEmail("info@imperial.lk")
                .setUserName("admin1")
                .setPassword("admin@123")
                .setConfirmPassword("admin@123")
                .submit();

        Assert.assertEquals(regSuccessPage.getSalutationMessage(),
                        "Dear " +firstName+ " " +lastName+ ",",
                "Failed to Create New User:");

    }
}
