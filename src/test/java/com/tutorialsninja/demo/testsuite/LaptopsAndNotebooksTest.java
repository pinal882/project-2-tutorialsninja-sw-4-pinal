package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends TestBase {

    HomePage homePage = new HomePage();
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
    MacBookPage macBookPage = new MacBookPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickOnLaptopAndNotebook();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Laptops & Notebooks");
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNoteBooksPage.getSortByPriceHighToLowSelection();
        //1.4 Verify the Product price will arrange in High to Low order.
        List<Double> expText = laptopsAndNoteBooksPage.getSortByPriceHighToLowSelection();
        List<Double> actText = laptopsAndNoteBooksPage.getSortByPriceHighToLowSelection();
        System.out.println("Expected list " + expText);
        Assert.assertEquals(Collections.singleton(actText), Collections.singleton(expText));
        System.out.println("Actual List " + actText);
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
       //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverAndClickOnLaptopAndNotebook();
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Laptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNoteBooksPage.selectPriceHighToLow();
        //2.4 Select Product “MacBook”
        laptopsAndNoteBooksPage.clickOnMacbook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(macBookPage.getTextFromMacBook(), "MacBook", "MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
macBookPage.clickOnAddToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(macBookPage.isSuccessMessageAppearing(), "Message Doesn't Appear");
        //2.8 Click on link “shopping cart” display into success message
        macBookPage.clickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getProductName(), "MacBook", "Product Name Doesn't appear");
        //2.11 Change Quantity "2"
        shoppingCartPage.clearAndAddQuantity("2");
        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdate();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(shoppingCartPage.isSuccessMessageAppearing(), "Cart not modified");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.getTotalText(), "£737.45", "Total not matched");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckout();
        Thread.sleep(2000);
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(checkOutPage.getCheckoutText(), "Checkout", "Checkout not displayed");
        //2.17 Verify the Text “New Customer”
        Thread.sleep(1000);
        Assert.assertEquals(checkOutPage.getNewCustomerText(), "New Customer", "New Customer not displayed");
        //2.18 Click on “Guest Checkout” radio button
        checkOutPage.clickOnGuestCheckoutRadioButton();
        //2.19 Click on “Continue” tab
        checkOutPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkOutPage.enterBillingDetails();
        //2.21 Click on “Continue” Button
        checkOutPage.clickOnContinueBillingButton();
        //2.22 Add Comments About your order into text area
        checkOutPage.enterComment();
        //2.23 Check the Terms & Conditions check box
        Thread.sleep(1000);
        checkOutPage.clickOnAgreeToTermsAndConditions();
        //2.24 Click on “Continue” button
        checkOutPage.clickOnContinueCommentButton();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertTrue(checkOutPage.isPaymentWarningAppearing(), "Payment Warning not displayed");
    }

}
