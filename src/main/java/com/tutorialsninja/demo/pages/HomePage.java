package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By topMenuListField = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktop = By.linkText("Desktops");

    By laptopandnotebook = By.xpath("//a[normalize-space()='Laptops & Notebooks']");
    By components = By.xpath("//a[normalize-space()='Components']");
    By showalldesktop = By.xpath("//a[normalize-space()='Show AllDesktops']");
    By currencydropdown = By.xpath("//i[@class='fa fa-caret-down']");
    By poundsterling = By.xpath("//button[normalize-space()='£Pound Sterling']");
    By showalllaptopandnotebooks = By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']");
    By componentsTab = By.linkText("Components");
    By showAllComponents = By.xpath("//a[normalize-space()='Show AllComponents']");
    By myAccounts = By.xpath("//span[contains(text(),'My Account')]");
    By registerAccountText = By.xpath("//h1[contains(text(),'Register Account')]");
    By loginAccountText = By.xpath("//h2[contains(text(),'Returning Customer')]");


    public void selectMenu(String menu) {
        if (menu == "Desktops") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            mouseHoverToElement(desktop);
            clickOnElement(showalldesktop);

        } else if (menu == "Laptops & Notebooks") {
            //Find Laptops & Notebooks tab, hover and click on "Show All Laptops & Notebooks"
            mouseHoverToElement(laptopandnotebook);
            clickOnElement(showalllaptopandnotebooks);

        } else if (menu == "Components") {
            //Find Components tab, hover and click on "Show All Components"
            mouseHoverToElement(componentsTab);
            clickOnElement(showAllComponents);

        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }

        public void mouseHoverAndClickOnDesktop() {
            selectMenu("Desktops");
        }
        public void mouseHoverAndClickOnLaptopAndNotebook() {
                selectMenu("Laptops & Notebooks");
            }
            public void mouseHoverAndClickOnComponents() {
                selectMenu("Components");
            }
               // public void clickOnShowAllDesktop() {
                 //   clickOnElement(showalldesktop);
               // }
                public void mousehoverAndClickOnCurrency() {
                    mouseHoverToElementAndClick(currencydropdown);
                }
                public void mousehoverAndClickOn£PoundSterling() {
                    mouseHoverToElementAndClick(poundsterling);
                }
                public void clickOnShowAllLaptopsAndNotebooks() {
                    clickOnElement(showalllaptopandnotebooks);
                }
                public void selectMyAccountOptions (String option){
                    //This method should click on the options whatever name is passed as parameter.
                    List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));//list with two options(do multi select)
                    for (WebElement option1 : registerList) {
                        if (option1.getText().equals(option)) {
                            option1.click();
                            break;
                        }
                    }
                }public void clickOnMyAccount () {
                    clickOnElement(myAccounts);
                }

                public String getRegisterAccountText () {
                    return getTextFromElement(registerAccountText);
                }

                public String getLoginAccountText () {
                    return getTextFromElement(loginAccountText);
                }
            }




