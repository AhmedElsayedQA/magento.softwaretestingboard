package com.softwaretestingboard.magneto.tests;

import com.softwaretestingboard.magneto.pages.CreatAnAccountPage;
import org.testng.annotations.Test;


import java.util.Random;

public class ComparisonFlowTests extends BaseTests{
    int firstProductNumber=1;
    int secondProductNumber=2;
    Random rand = new Random();
    String email=rand.nextInt(1000)+"@test.com";
    @Test
    public void createAnAccount(){
        homePage.clickCreateAnAccountBtn()
                .enterFirstName("Ahmed").enterLastName("ElSayed")
                .enterEmail(email).enterPassword("Ae1234567!").enterConfirmPassword("Ae1234567!")
                .submitCreateAnAccountBtn();
        creatAnAccountPage = new CreatAnAccountPage(driver);
        softAssert.assertTrue(creatAnAccountPage.getPageTitle().equals("My Account"),"Account Isn't Created");
        creatAnAccountPage.goToHomePage();
        softAssert.assertTrue(driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/"),"Didn't navigate to Home Page");
        softAssert.assertAll();
    }

    @Test
    public void addProductsToComparisonList(){
        String productName =homePage.getProductName(firstProductNumber);
        System.out.println(productName);
        homePage.hoverOnHotSellerItem(firstProductNumber).clickAddToCompareBtn(firstProductNumber);
        System.out.println(homePage.getAddToComparisonListSuccessMsg());
        System.out.println("You added product "+productName+" to the comparison list.");
        softAssert.assertTrue(homePage.getAddToComparisonListSuccessMsg()
                .equals("You added product "+productName+" to the comparison list."),"Wrong product Was added to The list");
        softAssert.assertAll();
    }
}
