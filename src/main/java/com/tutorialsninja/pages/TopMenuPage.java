package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuPage extends Utility {
    By desktop = By.xpath("//a[normalize-space()='Desktops']");
    By desktopText= By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsNoteBooks= By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']");
    By loptopsNotebookText=By.xpath("//h2[normalize-space()='Laptops & Notebooks']");
    By components = By.xpath("//a[normalize-space()='Components']");
    By componentsText= By.xpath("//h2[normalize-space()='Components']");


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

    public void clickOnDesktop() {
        mouseHoverAndClickOnElement(desktop);
    }
    public String verifyDesktopText(){
        return getTextFromElement(desktopText);
    }
    public void clickOnLaptopsAndNotebooks(){
        mouseHoverAndClickOnElement(laptopsNoteBooks);
    }
    public String verifyLaptopsAndNotebookText(){
        return getTextFromElement(loptopsNotebookText);
    }
    public void clickOnComponents(){
        mouseHoverAndClickOnElement(components);
    }
    public String verifyComponentsText(){
        return getTextFromElement(componentsText);
    }
}
