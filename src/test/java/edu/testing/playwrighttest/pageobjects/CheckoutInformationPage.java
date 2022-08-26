package edu.testing.playwrighttest.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutInformationPage {
    private final Page page;
    private final Locator firstName;
    private final Locator lastName;
    private final Locator zipCode;
    private final Locator continueButton;
    public CheckoutInformationPage(Page page) {
        this.page = page;
        this.firstName = page.locator("#first-name");
        this.lastName = page.locator("#last-name");
        this.zipCode = page.locator("#postal-code");
        this.continueButton = page.locator("#continue");
    }

    public CheckoutOverView fillingInformation(String firstName, String lastName, String zipCode){
        this.firstName.fill(firstName);
        this.lastName.fill(lastName);
        this.zipCode.fill(zipCode);
        continueButton.click();
        return new CheckoutOverView(this.page);
    }

}
