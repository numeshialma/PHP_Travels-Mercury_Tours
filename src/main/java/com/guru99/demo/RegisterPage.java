package com.guru99.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestApp;

import java.time.Duration;

public class RegisterPage {

    @FindBy(name = "firstName")
    private WebElement firstNameElement;

    @FindBy(name = "lastName")
    private WebElement lastNameElement;

    @FindBy(name = "phone")
    private WebElement phoneElement;

    @FindBy(name = "userName")  //(id="username")
    private WebElement emailElement;

    @FindBy(name = "email")
    private WebElement userNameElement;

    @FindBy(name = "password")
    private WebElement passwordElement;

    @FindBy(name = "confirmPassword")
    private  WebElement confirmPasswordElement;

    @FindBy(name = "submit")
    private WebElement submitElement;

    public RegisterPage setFirstName(String firstName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("firstName"),
                Duration.ofSeconds(10));

        firstNameElement.sendKeys(firstName);
        return this;
    }

    public RegisterPage setLastName(String lastName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("lastName"),
                Duration.ofSeconds(10));

        lastNameElement.sendKeys(lastName);
        return this;
    }

    public RegisterPage setPhone(String phone){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("phone"),
                Duration.ofSeconds(10));

        phoneElement.sendKeys(phone);
        return this;
    }

    public RegisterPage setEmail(String email){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("userName"),
                Duration.ofSeconds(10));
        emailElement.sendKeys(email);
        return this;
    }

    public RegisterPage setUserName(String userName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("email"),
                Duration.ofSeconds(10));
        userNameElement.sendKeys(userName);
        return this;
    }

    public RegisterPage setPassword(String password){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("password"),
                Duration.ofSeconds(10));
        passwordElement.sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String confirmPassword){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("confirmPassword"),
                Duration.ofSeconds(10));
        confirmPasswordElement.sendKeys(confirmPassword);
        return this;
    }

    public RegisterSuccessPage submit(){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("submit"),
                Duration.ofSeconds(10));
        submitElement.click();
        return PageFactory.initElements(TestApp.getInstance().getDriver(),
                RegisterSuccessPage.class);
    }

}
