package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class DesktopsPage extends Utility {
    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By pound = By.xpath("//button[contains(text(),'£Pound Sterling')]");
    By sort = By.id("input-sort");
    By hpL3065 = By.xpath("//a[contains(text(),'HP LP3065')]");
    By hpL3065Text = By.xpath("//h1[normalize-space()='HP LP3065']");
    By add2Cart = By.xpath("//button[@id='button-cart']");
    By successText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By dateText = By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']");
    By product21 = By.xpath("//td[normalize-space()='Product 21']");
    By totalText= By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]");

    public void changeCurrency() throws InterruptedException {
        mouseHoverOnElement(currency);
        Thread.sleep(3000);
        mouseHoverAndClickOnElement(pound);
    }

    public void sortByPositionName(String name) {
        selectFromVisibleTextFromDropdown(sort, name);
    }

    public void selectProductHp3065() {
        mouseHoverAndClickOnElement(hpL3065);
    }

    public String verifyHpL3065Text() {
        return getTextFromElement(hpL3065Text);
    }

    public void clickOnAdd2Cart() {
        clickOnElement(add2Cart);
    }

    public String verifySuccessText() {
        return getTextFromElement(successText);
    }

    public void clickOnLinkShoppingCart() {
        clickOnElement(shoppingCart);
    }
    public String verifyDateText() {
        return getTextFromElement(dateText);
    }
    public String verifyProductText() {
        return getTextFromElement(product21);
    }
    public String verifyTotalText() {
        return getTextFromElement(totalText);
    }

}
