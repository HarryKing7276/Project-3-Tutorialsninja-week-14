package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {
    TopMenuPage topMenu = new TopMenuPage();
    DesktopsPage desktops = new DesktopsPage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        //1.1 Mouse hover on Desktops Tab.and click
        topMenu.clickOnDesktop();

        //1.2 Click on “Show All Desktops
        topMenu.selectMenu("Show AllDesktops");

        Thread.sleep(3000);

        //1.3 Select Sort By position "Name: Z to A
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);

        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        //1.3 Select Sort By position "Name: Z to A"
        desktops.sortByPositionName("Name (Z - A)");

        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        desktops.changeCurrency();

        //2.1 Mouse hover on Desktops Tab.and click
        topMenu.clickOnDesktop();

        //2.2 Click on “Show All Desktops
        topMenu.selectMenu("Show AllDesktops");

        //2.3 Select Sort By position "Name: Z to A"
        desktops.sortByPositionName("Name (A - Z)");

        //2.4 Select product “HP LP3065”
        desktops.selectProductHp3065();

        //2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = desktops.verifyHpL3065Text();
        Assert.assertEquals(actualText, expectedText);

        //2.6 Select Delivery Date "2023-11-30"
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

        //2.8 Click on “Add to Cart” button
        desktops.clickOnAdd2Cart();

/*
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedText1= "Success: You have added HP LP3065 to your shopping cart!";
        String actualText1= desktops.verifySuccessText();
        Assert.assertEquals(actualText1,expectedText1);*/

        // 2.10 Click on link “shopping cart” display into success message
        desktops.clickOnLinkShoppingCart();
/*
        //2.11 Verify the text "Shopping Cart"
        String expectedText2= "Success: You have added HP LP3065 to your shopping cart!";
        String actualText2= desktops.verifySuccessText();
        Assert.assertEquals(actualText2,expectedText2);*/

        //2.12 Verify the Product name "HP LP3065"
        String expectedText3= "HP LP3065";
        String actualText3= desktops.verifyHpL3065Text();
        Assert.assertEquals(actualText3,expectedText3);

        // 2.13 Verify the Delivery Date "2022-11-30"
        String expectedText4= "2022-11-30";
        String actualText4= desktops.verifyDateText();
        Assert.assertEquals(actualText4,expectedText4);

        //2.14 Verify the Model "Product21"
        String expectedText5= "Product21";
        String actualText5= desktops.verifyProductText();
        Assert.assertEquals(actualText5,expectedText5);

        //2.15 Verify the Total "£74.73"
        String expectedText6= "£74.73";
        String actualText6= desktops.verifyTotalText();
        Assert.assertEquals(actualText6,expectedText6);


    }
}
