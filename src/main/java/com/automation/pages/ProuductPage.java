package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProuductPage extends Utility {

    public ProuductPage() {
        PageFactory.initElements(driver, this);}

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(id = "group_1")
    WebElement selectSize;

    @FindBy(className = "attribute_list")
    WebElement color;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement popUpDisplay;

    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeButton;

    public void addProductAttribute(String qty, String size, String colour) {
        sendKeysToElement(quantity, Keys.BACK_SPACE + qty);
        CustomListeners.test.log(Status.PASS,"Enter quantity: " + qty);

        selectByVisibleTextFromDropDown(selectSize, size);
        CustomListeners.test.log(Status.PASS,"Select size from dropdown: " + size);

        clickOnElement(color, colour);
        CustomListeners.test.log(Status.PASS,"Click on colour " + colour);
    }

    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS,"Click on Add to cart button ");
    }

    public void verifyProductAddedToCartMessage(String text){
        verifyThatTextIsDisplayed(popUpDisplay, text);
        CustomListeners.test.log(Status.PASS,"Verify 'Product added to cart' message " + text);
    }

    public void clickOnCloseButton(){
        clickOnElement(closeButton);
        CustomListeners.test.log(Status.PASS,"Click on close button ");
    }

}
