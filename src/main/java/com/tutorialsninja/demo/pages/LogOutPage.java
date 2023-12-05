package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;

public class LogOutPage extends Utility {
    By logoutText = By.xpath("//h1[contains(text(),'Account Logout')]");

    public String getTextFromLogout() {
        return getTextFromElement(logoutText);
    }
}
