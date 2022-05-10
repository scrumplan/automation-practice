package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class WomenCategoryPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    WomenCategoryPage womenCategoryPage;
    ProuductPage productPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void initialize(){

        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProuductPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){

        homePage.selectMenu("Women");
        womenCategoryPage.verifyWomenText("Women");
    }

    @Test (groups = {"regression"}, dataProvider = "product", dataProviderClass = TestData.class)
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour){
        homePage.selectMenu("Women");
        womenCategoryPage.addProductToCart(product);
        productPage.addProductAttribute(qty, size, colour);
        productPage.clickOnAddToCartButton();
        productPage.verifyProductAddedToCartMessage("Product successfully added to your shopping cart");
        productPage.clickOnCloseButton();

    }

}
