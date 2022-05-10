package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenCategoryPage extends Utility {
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='category-name']")
    WebElement womenText;

    @FindBy(xpath = "//a[@class='product-name']")
    WebElement productsList;

    public void verifyWomenText(String text) {
        verifyThatTextIsDisplayed(womenText, text);
        CustomListeners.test.log(Status.PASS,"Verify Women text is visible " + text);
    }

    public void addProductToCart(String product) {
        clickOnElement(productsList, product);
        CustomListeners.test.log(Status.PASS,"Click on Add product to cart " + product);
    }
}
