package edu.testing.playwrighttest.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutComplete {
    private final Page page;
    private final Locator sucessMessage;
    public CheckoutComplete(Page page) {
        this.page = page;
        this.sucessMessage = page.locator("h2.complete-header");
    }

    public String getSuccessMessage(){
        return sucessMessage.innerText();
    }
}
