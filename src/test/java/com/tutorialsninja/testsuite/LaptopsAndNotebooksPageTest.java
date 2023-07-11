package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPageTest extends BaseTest {
    TopMenuPage topMenu = new TopMenuPage();
    LaptopsAndNotebooksPage laptopsAndNotebooks = new LaptopsAndNotebooksPage();
    DesktopsPage desktops = new DesktopsPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        topMenu.clickOnLaptopsAndNotebooks();

        //1.2 Click on “Show All Laptops & Notebooks"
        topMenu.selectMenu("Show AllLaptops & Notebooks");
        Thread.sleep(3000);

        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);

        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);

        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooks.sortByPositionName("Price (High > Low)");

        // After filter Price (High > Low) Get all the products price and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);

        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(originalProductsPrice, afterSortByPrice);

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        desktops.changeCurrency();

        //2.1 Mouse hover on Laptops & Notebooks Tab.and click
        topMenu.clickOnLaptopsAndNotebooks();

        //2.2 Click on “Show All Laptops & Notebooks"
        topMenu.selectMenu("Show AllLaptops & Notebooks");
        Thread.sleep(3000);

        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooks.sortByPositionName("Price (High > Low)");

        //2.4 Select Product “MacBook”
        laptopsAndNotebooks.clickOnMcBook();

        //2.5 Verify the text “MacBook”
        String expectedText = "MacBook";
        String actualText = laptopsAndNotebooks.getMacBookText();
        Assert.assertEquals(actualText, expectedText);

        //2.6 Click on ‘Add To Cart’ button
        laptopsAndNotebooks.clickOnAddToCart();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!"
        String expectedText1 = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        String actualText1 = laptopsAndNotebooks.getSuccessText();
        Assert.assertEquals(actualText1, expectedText1);

        //2.8 Click on link “shopping cart” display into success message
        laptopsAndNotebooks.clickOnShoppingCartLink();

        //2.9 Verify the text "Shopping Cart"
        String expectedText3 = "Shopping Cart  (0.00kg)";
        String actualText3 = laptopsAndNotebooks.getShoppingCartText();
        Assert.assertEquals(actualText3,expectedText3);

        //2.10 Verify the Product name "MacBook"
        String expectedText4 = "MacBook";
        String actualText4 = laptopsAndNotebooks.getMackBookText();
        Assert.assertEquals(actualText4,expectedText4);

        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//input[contains(@name, 'quantity')]")).clear();
        laptopsAndNotebooks.changeQuantity();

        //2.12 Click on “Update” Tab
        laptopsAndNotebooks.clickOnUpdateCart();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedText5 = "Success: You have modified your shopping cart!\n" +
                "×";
        String actualText5 = laptopsAndNotebooks.getSuccessText();
        Assert.assertEquals(actualText5,expectedText5);
/*
        //2.14 Verify the Total £737.45
        String expectedText6 = "£737.45";
        String actualText6 = laptopsAndNotebooks.getMackBookPriceText();
        Assert.assertEquals(actualText6,expectedText6);*/

        //2.15 Click on “Checkout” button
        laptopsAndNotebooks.clickOnCheckOutButton();

        //2.16 Verify the text “Checkout”
        String expectedText9 = "Checkout";
        String actualText9 = laptopsAndNotebooks.getCheckOutText();
        Assert.assertEquals(actualText9,expectedText9);

        //2.17 Verify the Text “New Customer”
        String expectedText7 = "New Customer";
        String actualText7 = laptopsAndNotebooks.getNewCustomerText();
        Assert.assertEquals(actualText7,expectedText7);

        //2.18 Click on “Guest Checkout” radio button
        laptopsAndNotebooks.clickOnGuestCheckOut();

        //2.19 Click on “Continue” tab
        laptopsAndNotebooks.clickOnContinueButton();

        // 2.20 Fill the mandatory fields
        laptopsAndNotebooks.enterFirstName("Prime");
        laptopsAndNotebooks.enterLastName("Testing");
        laptopsAndNotebooks.enterEmail("primetest123@gmail.com");
        laptopsAndNotebooks.enterPhoneNumber("123456789");
        laptopsAndNotebooks.enterAddress1("20 Downing Street");
        laptopsAndNotebooks.enterCity("London");
        laptopsAndNotebooks.enterPostCode("NW10 1HA");
        laptopsAndNotebooks.selectCountry("United Kingdom");
        laptopsAndNotebooks.selectRegion("Hertfordshire");

        //2.21 Click on “Continue” Button

        laptopsAndNotebooks.clickOnGuestContinue();

        //2.22 Add Comments About your order into text area
        laptopsAndNotebooks.enterComments("My mackBook");

        //2.23 Check the Terms & Conditions check box
        laptopsAndNotebooks.clickOnAgree();

        //2.24 Click on “Continue” button
        laptopsAndNotebooks.clickOnLastContinueCheckOutButton();

        //2.25 Verify the message “Warning: Payment method required!”
        String expectedText8 = "Warning: No Payment options are available. Please contact us for assistance!";
        String actualText8  = laptopsAndNotebooks.getPaymentWarningText();
        Assert.assertEquals(actualText8,expectedText8);

    }
}
