package edu.testing.playwrighttest.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutOverView {
    private final Page page;
    private final Locator finishButton;
    public CheckoutOverView(Page page) {
        this.page = page;
        this.finishButton = page.locator("#finish");
    }

    public CheckoutComplete clickFinish(){
        finishButton.click();
        return new CheckoutComplete(this.page);
    }
}
