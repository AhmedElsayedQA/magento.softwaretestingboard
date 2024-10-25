package com.softwaretestingboard.magneto.tests;

import com.softwaretestingboard.magneto.pages.CreatAnAccountPage;
import org.testng.annotations.Test;


import java.util.Random;

public class ComparisonFlowTests extends BaseTests {
    int firstProductNumber = 3;
    int secondProductNumber = 5;
    Random rand = new Random();
    String firstProductName;
    String secondProductName;

    String email = rand.nextInt(1000) + "@test.com";

    @Test(priority = 1)
    public void verifyCreatingAnAccount() {
        homePage.clickCreateAnAccountBtn()
                .enterFirstName("Ahmed").enterLastName("ElSayed")
                .enterEmail(email).enterPassword("Ae1234567!").enterConfirmPassword("Ae1234567!")
                .submitCreateAnAccountBtn();

        creatAnAccountPage = new CreatAnAccountPage(driver);
        softAssert.assertEquals(creatAnAccountPage.getPageTitle(), "My Account", "Account Isn't Created");
        creatAnAccountPage.goToHomePage();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/",
                "Didn't navigate to Home Page");
        softAssert.assertAll();
    }

    @Test(description = "Test Adding Two products to the Comparison List", priority = 2)
    public void verifyAddingProductsToComparisonList() {
        // get data for validations
        firstProductName = homePage.getProductName(firstProductNumber);
        secondProductName = homePage.getProductName(secondProductNumber);

        // add two products to the comparison list
        homePage.hoverOnHotSellerItem(firstProductNumber).clickAddToCompareBtn(firstProductNumber);
        softAssert.assertEquals(homePage.getAddToComparisonListSuccessMsg(),
                "You added product " + firstProductName + " to the comparison list.",
                "Wrong product Was added to The list");

        homePage.hoverOnHotSellerItem(secondProductNumber).clickAddToCompareBtn(secondProductNumber);
        softAssert.assertEquals(homePage.getAddToComparisonListSuccessMsg(),
                "You added product " + secondProductName + " to the comparison list.",
                "Wrong product Was added to The list");

        // Verify that Comparison List contains the previously added products
        comparisonPage = homePage.goToComparisonPage();
        softAssert.assertEquals(comparisonPage.getPageTitle(), "Compare Products", "Didn't navigate to Comparison Page");
        softAssert.assertEquals(comparisonPage.getFirstProductName(), firstProductName, "Wrong Product Added");
        softAssert.assertEquals(comparisonPage.getSecondProductName(), secondProductName, "Wrong Product Added");
        softAssert.assertAll();
    }


}
