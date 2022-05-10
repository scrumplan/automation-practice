package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Women']")
    WebElement women;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;

    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement logoLocator;


    public void clickOnWomenTab() {
        clickOnElement(women);
        CustomListeners.test.log(Status.PASS, "Click on women tab ");
    }

    public void clickOnSignInLink() {
        clickOnElement(signInLink);
        CustomListeners.test.log(Status.PASS, "Click on Sign In button ");
    }

    public void verifyLogoisVisible() {
        verifyThatElementIsDisplayed(logoLocator);
        CustomListeners.test.log(Status.PASS, "Verify Logo is visible ");
    }

    // This method will select top menu categroy
    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@id='block_top_menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }


}
