package com.softwaretestingboard.magneto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatAnAccountPage {

    private WebDriver driver;
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By creatAnAccountBtn = By.xpath("//button[@class='action submit primary']");
    private By welcomeMsg=By.className("logged-in");
    private By pageTitle=By.className("base");
    private By logo=By.className("logo");


    public CreatAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public CreatAnAccountPage enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
        return new CreatAnAccountPage(driver);
    }
    public CreatAnAccountPage enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
        return new CreatAnAccountPage(driver);
    }

    public CreatAnAccountPage enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return new CreatAnAccountPage(driver);
    }

    public CreatAnAccountPage enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return new CreatAnAccountPage(driver);
    }

    public CreatAnAccountPage enterConfirmPassword(String confirmPassword){
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        return new CreatAnAccountPage(driver);
    }
    public CreatAnAccountPage submitCreateAnAccountBtn(){
        driver.findElement(creatAnAccountBtn).submit();
        return new CreatAnAccountPage(driver);
    }
    public String getUserName(){
       return driver.findElement(welcomeMsg).getText();
    }

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public HomePage goToHomePage(){
        driver.findElement(logo).click();
        return new HomePage(driver);
    }
}
