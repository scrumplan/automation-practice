package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Utility {

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='radio']")
    WebElement selectTitle;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "firstname")
    WebElement addressFirstName;

    @FindBy(id = "lastname")
    WebElement addressLastName;

    @FindBy(id = "address1")
    WebElement addressLine1;

    @FindBy(id = "city")
    WebElement addressCity;

    @FindBy(id = "id_state")
    WebElement addressState; // dropdown

    @FindBy(id = "postcode")
    WebElement addressPostcode;     // only 5 digits

    @FindBy(id = "id_country")
    WebElement addressCountry;  // dropdown

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountText;


    public void enterPersonalInformation(String name, String lstName, String title, String passwrd){
        clickOnElement(selectTitle, title);      // select title
        CustomListeners.test.log(Status.PASS,"Select title: " + title);

        sendTextToElement(firstName, name);     // Input First Name
        CustomListeners.test.log(Status.PASS,"Enter First name: " + name);

        sendTextToElement(lastName, lstName);     // Input Last Name
        CustomListeners.test.log(Status.PASS,"Enter Last name: " + lstName);

        sendTextToElement(password, passwrd);     // Input password Name
        CustomListeners.test.log(Status.PASS,"Enter Password: " + passwrd);
    }

    public void enterAddressDetails(String fName, String lstName,
                                    String address, String city, String state, String postcode, String mobile){
        sendTextToElement(addressFirstName, fName);      // Address first name
        CustomListeners.test.log(Status.PASS,"Enter First name for address field: " + fName);

        sendTextToElement(addressLastName, lstName);       // Address last name
        CustomListeners.test.log(Status.PASS,"Enter Last name for address field: " + lstName);

        sendTextToElement(addressLine1, address);       // Address
        CustomListeners.test.log(Status.PASS,"Enter first line of address: " + address);

        sendTextToElement(addressCity, city);       // Address City name
        CustomListeners.test.log(Status.PASS,"Enter city: " + city);

        selectByVisibleTextFromDropDown(addressState, state);  // Address State
        CustomListeners.test.log(Status.PASS,"Select state from dropdown: " + state);

        sendTextToElement(addressPostcode, postcode);   // Postalcode
        CustomListeners.test.log(Status.PASS,"Enter Postal code: " + postcode);

        sendTextToElement(mobilePhone, mobile);     // mobile number
        CustomListeners.test.log(Status.PASS,"Enter mobile number: " + mobile);
    }

    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS,"Click on register button ");
    }

    public void verifyMyAccountText(String text){
        verifyThatTextIsDisplayed(myAccountText, text);
        CustomListeners.test.log(Status.PASS,"Verify 'My Account' text is displayed " + text);
    }

}
