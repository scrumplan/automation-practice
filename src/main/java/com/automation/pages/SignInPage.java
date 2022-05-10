package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class SignInPage extends Utility {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "email")
    WebElement emailAddressField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(xpath = "//h1[contains(text(),'Authentication')]")
    WebElement authenticationMessage;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(id = "email_create")
    WebElement createAccountEmail;

    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    WebElement createAccountText;


    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    WebElement emailRequiredError;

    @FindBy(xpath = "//li[contains(text(),'Password is required.')]")
    WebElement passwordRequiredError;

    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement invalidEmail;

    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement authenticationFailed;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;


    public void verifyAuthenticationMessage(String text) {
        verifyThatTextIsDisplayed(authenticationMessage, text);
        CustomListeners.test.log(Status.PASS, "Verify 'Authentication' message is displayed " + text);
    }

    public void inputEmailAddress(String text) {
        sendTextToElement(emailAddressField, text);
        CustomListeners.test.log(Status.PASS, "Enter email address: " + text);
    }

    public void inputPassword(String text) {
        sendTextToElement(passwordField, text);
        CustomListeners.test.log(Status.PASS, "Enter password: " + text);
    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
        CustomListeners.test.log(Status.PASS, "Click on Sign In button ");
    }

    public void verifySignOutLinkIsVisible() {
        verifyThatElementIsDisplayed(logoutButton);
        CustomListeners.test.log(Status.PASS, "Verify Sign Out link is visible ");
    }

    public void clickOnSignOutLink() {
        clickOnElement(logoutButton);
        CustomListeners.test.log(Status.PASS, "Click on Sign Out button ");
    }

    public void verifySignInLinkVisible() {
        verifyThatElementIsDisplayed(signInLink);
        CustomListeners.test.log(Status.PASS, "Verify Sign In link is visible ");
    }

    public void inputEmailToCreateAccount(String text) {
        sendTextToElement(createAccountEmail, text);
        CustomListeners.test.log(Status.PASS, "Enter email to create account: " + text);
    }

    public void clickOnCreateAccountButton() {
        clickOnElement(createAccountButton);
        CustomListeners.test.log(Status.PASS, "Click on Create Account button ");
    }

    public void inputCredentials(String username, String password) {
        sendTextToElement(emailAddressField, username);
        CustomListeners.test.log(Status.PASS, "Enter username: " + username);

        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password: " + password);
    }

    // This method will get error message
    public void verifyErrorMessage(String errorMessage) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(errorMessage)) {
                break;
            }
        }
    }

}
