package com.softwaretestingboard.magneto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;
    private By createAnAccountBtn = By.xpath("//a[text()='Create an Account']");
    private By hotSellerSection=By.xpath("//a[text()='Hot Sellers']");
    private By hotSellersProductsName=By.xpath("//strong[@class='product-item-name']");
    private By addToCompareBtn=By.xpath("//a[@class='action tocompare']");
    private By comparisonListLink=By.xpath("//a[text()='comparison list']");
    private By addToComparisonsucessMsg=By.className("messages");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CreatAnAccountPage clickCreateAnAccountBtn(){
        driver.findElement(createAnAccountBtn).click();
        return new CreatAnAccountPage(driver);
    }

    public HomePage scrollToHotSellerSection(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hotSellerSection));
        return new HomePage(driver);
    }
    public HomePage hoverOnHotSellerItem(int productNumber){
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElements(hotSellersProductsName).get(productNumber-1)).build().perform();
        return new HomePage(driver);
    }

    public HomePage clickAddToCompareBtn(int productNumber){
        driver.findElements(addToCompareBtn).get(productNumber-1).click();
        return new HomePage(driver);
    }

    public ComparisonPage goToComparisonPage(){
        driver.findElement(comparisonListLink).click();
        return new ComparisonPage(driver);
    }
    public String getAddToComparisonListSuccessMsg(){
        return driver.findElement(addToComparisonsucessMsg).getText();
    }
    public String getProductName(int productNumber){
        return driver.findElements(hotSellersProductsName).get(productNumber-1).getText();
    }
}
