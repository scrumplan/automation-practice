package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class CreateAccountPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void initialize() {

        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnSignInLink();
        signInPage.inputEmailToCreateAccount(getRandomEmail());
        signInPage.clickOnCreateAccountButton();
        createAccountPage.enterPersonalInformation("Harry", "Potter", "Mr.", "Harry123");
        createAccountPage.enterAddressDetails("Harry", "Potter", "10 Downing Street",
                "London", "California", "36401", "01234859674");
        createAccountPage.clickOnRegisterButton();
        createAccountPage.verifyMyAccountText("My account");
    }


}
