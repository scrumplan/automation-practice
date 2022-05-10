package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class SignPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void initialize() {
        homePage = new HomePage();
        signInPage = new SignInPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void userShouldNavigateToSignInPageSuccessFully() {
        homePage.clickOnSignInLink();
        signInPage.verifyAuthenticationMessage("Authentication");
    }

    @Test(groups = {"sanity", "regression"}, dataProvider = "credentials", dataProviderClass = TestData.class)
    public void verifyTheErrorMessageWithInValidCredentials
            (String username, String password, String errorMessage) {
        userShouldNavigateToSignInPageSuccessFully();
        signInPage.inputCredentials(username, password);
        signInPage.clickOnSignInButton();
        signInPage.verifyErrorMessage(errorMessage);
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        userShouldNavigateToSignInPageSuccessFully();
        signInPage.inputEmailAddress("harry.potter@gmail.com");
        signInPage.inputPassword("Abcd1234");
        signInPage.clickOnSignInButton();
        signInPage.verifySignOutLinkIsVisible();
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully() {
        verifyThatUserShouldLogInSuccessFullyWithValidCredentials();
        signInPage.clickOnSignOutLink();
        signInPage.verifySignInLinkVisible();
    }
}
