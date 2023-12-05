package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {
    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String name){
    }
    //1.2 This method should click on the menu whatever name is passed as parameter.

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktop();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        //homePage.selectMenu("Show All Desktops");
        Thread.sleep(5000);
        //1.3 Verify the text ‘Desktops’
        String expectedDesktop = "Desktops";
        String actualDesktop = desktopsPage.getDesktopText();
        //verify if user is navigated to the correct page
        Assert.assertEquals(actualDesktop, expectedDesktop, "Desktop not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverAndClickOnLaptopAndNotebook();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = laptopsAndNoteBooksPage.getLaptopAndNoteBookText();
        //verify if user is navigated to the correct page
        Assert.assertEquals(actualText,expectedText,"Laptops And Notebooks not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
homePage.mouseHoverAndClickOnComponents();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show All Components");
        //3.3 Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = componentsPage.getComponentsText();
        //verify if user is navigated to the correct page
        Assert.assertEquals(actualText,expectedText,"Components Page not displayed");
    }
}
