package com.guru99.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.TestApp;

public class RegisterUserStepDef {

    HomePage homePage;
    RegisterPage registerPage;
    RegisterSuccessPage registerSuccessPage;

    @Given("^User is on Mercury Home Page --> Register Page$")
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        homePage= PageFactory.initElements
                (TestApp.getInstance().getDriver(), HomePage.class);
        registerPage=homePage.selectRegisterMenu();
    }

    @Given("^User enter first name as \"([^\"]*)\"$")
    public void setFirstName(String firstName)  {
        registerPage.setFirstName(firstName);
    }

    @And("^User enter last name as \"([^\"]*)\"$")
    public void setLastName(String lastName)  {
        registerPage.setLastName(lastName);
    }

    @And("^User enter phone number as \"([^\"]*)\"$")
    public void setPhoneNumber(String phoneNumber)  {
        registerPage.setPhone(phoneNumber);
    }

    @And("^User enter email address as \"([^\"]*)\"$")
    public void setEmailAddress(String emailAddress)  {
        registerPage.setEmail(emailAddress);
    }

    @And("^User enter user name as \"([^\"]*)\"$")
    public void setUserName(String userName)  {
        registerPage.setUserName(userName);
    }

    @And("^user enter password as \"([^\"]*)\"$")
    public void setPassword(String password)  {
        registerPage.setPassword(password);
    }

    @And("^user enter confirm password as \"([^\"]*)\"$")
    public void setConfirmPassword(String confirmPassword)  {
        registerPage.setConfirmPassword(confirmPassword);
    }

    @When("^User clicks on submit$")
    public void submit() {
        registerSuccessPage=registerPage.submit();
    }

    @Then("^Salutation message will display as \"([^\"]*)\"$")
    public void verifySalutationMessage(String expectedMessage)  {
        Assert.assertEquals(registerSuccessPage.getSalutationMessage(),
                expectedMessage,
                "Failed to create New User :");
    }
}
