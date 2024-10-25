package com.softwaretestingboard.magneto.tests;

import com.softwaretestingboard.magneto.pages.ComparisonPage;
import com.softwaretestingboard.magneto.pages.CreatAnAccountPage;
import com.softwaretestingboard.magneto.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;
    protected CreatAnAccountPage creatAnAccountPage;
    protected ComparisonPage comparisonPage;

    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage =new HomePage(driver);
        softAssert=new SoftAssert();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
