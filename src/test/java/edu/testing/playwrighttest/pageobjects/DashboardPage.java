package edu.testing.playwrighttest.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage  {
    private final Page page;
    private final Locator logoDashboard;
    private final Locator chooseFirstProduct;
    private final Locator cart;

    public DashboardPage(Page page){
        this.page = page;
        this.logoDashboard = page.locator("#logout_sidebar_link");
        this.chooseFirstProduct = page.locator("#add-to-cart-sauce-labs-backpack");
        this.cart = page.locator("#shopping_cart_container a.shopping_cart_link");
    }
    public boolean isLogoDashboardDisplayed() {
        return logoDashboard.isVisible();
    }

    public void chooseFirstProduct() {
        chooseFirstProduct.click();
    }

    public YourCartPage goCart() {
        cart.click();
        return new YourCartPage(this.page);
    }
}
