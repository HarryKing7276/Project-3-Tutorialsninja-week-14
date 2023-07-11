package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    TopMenuPage topMenu = new TopMenuPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //1.1 Mouse hover on “Desktops” Tab and click
        topMenu.clickOnDesktop();

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        topMenu.selectMenu("Show AllDesktops");

        //1.3 Verify the text ‘Desktops’
        String expectedText= "Desktops";
        String actualText= topMenu.verifyDesktopText();
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        topMenu.clickOnLaptopsAndNotebooks();

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        topMenu.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText= "Laptops & Notebooks";
        String actualText= topMenu.verifyLaptopsAndNotebookText();
        Assert.assertEquals(actualText,expectedText);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        //3.1 Mouse hover on “Components” Tab and click
        topMenu.clickOnComponents();

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        topMenu.selectMenu("Show AllComponents");

        //3.3 Verify the text ‘Components’
        String expectedText= "Components";
        String actualText= topMenu.verifyComponentsText();
        Assert.assertEquals(actualText,expectedText);
    }
}
