package edu.testing.playwrighttest.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LeftPanelPage {
    private final Page page;
    private final Locator logout;

    public LeftPanelPage(Page page){
        this.page = page;
        this.logout = page.locator("#logout_sidebar_link");
    }
    public void clickLogout() {
        logout.click();
    }
}
