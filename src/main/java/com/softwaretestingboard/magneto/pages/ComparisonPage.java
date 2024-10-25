package com.softwaretestingboard.magneto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparisonPage {

    private WebDriver driver;
    private By pageTitle=By.className("base");
    private By productName=By.className("product-item-name");


    public ComparisonPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public String getProductName(int productNumber){
        return driver.findElements(productName).get(productNumber).getText();
    }
}

