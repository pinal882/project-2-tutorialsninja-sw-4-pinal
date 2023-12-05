package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * //1.1 create method with name "selectMyAccountOptions" it has one parameter name
 *     //"option" of type string
 *     //1.2 This method should click on the options whatever name is passed as parameter.
 *     //(Hint: Handle List of Element and Select options)
 */
public class MyAccount extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    AccountCreationPage accountCreationPage = new AccountCreationPage();
    AccountPage accountPage = new AccountPage();
    LoginPage loginPage = new LoginPage();
    LogOutPage logoutPage = new LogOutPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //1.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(homePage.getRegisterAccountText(), "Register Account", "Register page not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(homePage.getLoginAccountText(), "Returning Customer", "Login page not displayed");

    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        Thread.sleep(1000);
        //3.3 Enter First Name
        registerPage.sendFirstName("abc");
        //3.4 Enter Last Name
        registerPage.sendLastName("sh");
        //3.5 Enter Email
        registerPage.sendEmail("abc");
        //3.6 Enter Telephone
        registerPage.sendTelephone("07854345678");
        //3.7 Enter Password
        registerPage.sendPassword("abc123");
        //3.8 Enter Password Confirm
        registerPage.sendConfirmPassword("abc123");
        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnSubscribeToNewsletter();
        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicy();
        //3.11 Click on Continue button
        registerPage.clickOnContinueAfterPrivacyButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountCreationPage.getAccountCreationMessage(), "Your Account Has Been Created!", "account not created");
        //3.13 Click on Continue button
        accountCreationPage.clickOnContinueAfterAccountCreation();
        //3.14 Click on My Account Link.
        accountPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOption("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(logoutPage.getTextFromLogout(), "Account Logout", "not logged out");
        //3.17 Click on Continue button
        accountPage.clickOnContinueAfterLogout();

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        loginPage.sendEmail("abc@gmail.com");
        //4.4 Enter Last Name
        //4.5 Enter Password
        loginPage.sendPassword("abc123");
        //4.6 Click on Login button
        loginPage.clickOnLogin();
        //4.7 Verify text “My Account”
        Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Not on my account");
        //4.8 Click on My Account Link.
        accountPage.clickOnMyAccountLink();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        Assert.assertEquals(logoutPage.getTextFromLogout(), "Account Logout", "Not logged out");
        //4.11 Click on Continue button

    }

}
