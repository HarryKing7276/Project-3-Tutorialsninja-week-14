package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LaptopsAndNotebooksPage extends Utility {
    By sort= By.xpath("//select[@id='input-sort']");
    By macBook= By.linkText("MacBook");
    By productText =By.xpath("//h1[normalize-space()='MacBook']");
    By addToCart =By.xpath("//button[@id='button-cart']");
    By successText =By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartLink = By.xpath("//a[normalize-space()='shopping cart']");
    By shoppingCartText =By.xpath("//h1[contains(text(),'Shopping Cart')]");
    By mackBookText =By.xpath("(//a[contains(text(),'MacBook')])[2]");
    By chgQty= By.xpath("//input[contains(@name, 'quantity')]");
    By updateCart= By.xpath("//button[@type='submit']");
    By mackBookPriceText =By.xpath("(//td[@class='text-right'][normalize-space()='$1,204.00'])[3]");
    By checkOut =By.xpath("//a[@class='btn btn-primary']");
    By checkOutText = By.xpath("//h1[normalize-space()='Checkout']");
    By newCustomerText = By.xpath("//h2[normalize-space()='New Customer']");
    By guestCheckOut = By.xpath("//input[@value='guest']");
    By continueButton = By.xpath("//input[@id='button-account']");
    By firstName = By.xpath("//input[@id='input-payment-firstname']");
    By lastName = By.xpath("//input[@id='input-payment-lastname']");
    By email = By.xpath("//input[@id='input-payment-email']");
    By telephone = By.xpath("//input[@id='input-payment-telephone']");
    By address1 = By.xpath("//input[@id='input-payment-address-1']");
    By city = By.xpath("//input[@id='input-payment-city']");
    By postcode = By.xpath("//input[@id='input-payment-postcode']");
    By country = By.xpath("//select[@id='input-payment-country']");
    By region = By.xpath("//select[@id='input-payment-zone']");
    By comments = By.xpath("//textarea[@name='comment']");
    By agree = By.xpath("//input[@type='checkbox']");
    By continueButtonLast = By.xpath("//input[@id='button-payment-method']");
    By warningText = By.xpath("//div[@class='alert alert-warning alert-dismissible']");
    By guestContinueButton = By.xpath("//input[@id='button-guest']");


    public void sortByPositionName(String name) {
        selectFromVisibleTextFromDropdown(sort, name);
    }
    public void clickOnMcBook(){
        clickOnElement(macBook);
    }
    public String getMacBookText(){
        return getTextFromElement(productText);
    }
    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }
    public String getSuccessText(){
        return getTextFromElement(successText);
    }
    public void clickOnShoppingCartLink(){
        clickOnElement(shoppingCartLink);
    }
    public String getShoppingCartText(){
        return getTextFromElement(shoppingCartText);
    }
    public String getMackBookText(){
        return getTextFromElement(mackBookText);
    }
    public void changeQuantity(){
        sendTextToElement(chgQty,"2");
    }
    public void clickOnUpdateCart(){
        clickOnElement(updateCart);
    }
    public String getMackBookPriceText(){
        return getTextFromElement(mackBookPriceText);
    }
    public void clickOnCheckOutButton(){
        clickOnElement(checkOut);
    }
    public void clickOnLastContinueCheckOutButton(){
        clickOnElement(continueButtonLast);
    }
    public String getCheckOutText(){
        return getTextFromElement(checkOutText);
    }
    public String getNewCustomerText(){
        return getTextFromElement(newCustomerText);
    }
    public void clickOnGuestCheckOut(){
        clickOnElement(guestCheckOut);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    public void enterFirstName(String firstNme){
        sendTextToElement(firstName, firstNme);
    }
    public void enterLastName(String name){
        sendTextToElement(lastName, name);
    }
    public void enterEmail(String value){
        sendTextToElement(email, value);
    }
    public void enterPhoneNumber(String value){
        sendTextToElement(telephone, value);
    }
    public void enterAddress1(String value){
        sendTextToElement(address1, value);
    }
    public void enterCity(String value){
        sendTextToElement(city, value);
    }
    public void enterPostCode(String value){
        sendTextToElement(postcode, value);
    }
    public void selectCountry(String value) {
        selectFromVisibleTextFromDropdown(country, value);
    }
    public void selectRegion(String value){
        selectFromVisibleTextFromDropdown(region, value);
    }
    public void clickOnGuestContinue(){
        clickOnElement(guestContinueButton);
    }
    public void enterComments(String value){
        sendTextToElement(comments, value);
    }
    public void clickOnAgree(){
        clickOnElement(agree);
    }
    public String getPaymentWarningText(){
        return  getTextFromElement(warningText);
    }
}
