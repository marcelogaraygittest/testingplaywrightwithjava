package edu.testing.playwrighttest.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class YourCartPage {
    private final Page page;
    private final Locator firstProductInList;
    private final Locator checkoutButton;
    public YourCartPage(Page page) {
        this.page = page;
        this.firstProductInList = page.locator("#item_4_title_link div");
        this.checkoutButton = page.locator("#checkout");
    }

    public String GetNameFirstProduct(){
        return firstProductInList.innerText();
    }

    public CheckoutInformationPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutInformationPage(this.page);
    }
}
