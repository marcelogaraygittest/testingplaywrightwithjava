package edu.testing.playwrighttest.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator userNameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.userNameInput = page.locator("[Placeholder=Username]");
        this.passwordInput = page.locator("[Placeholder=Password]");
        this.loginButton = page.locator("#login-button");
    }

    public void navigate() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void fillingLogin(String userName, String password) {
        userNameInput.fill(userName);
        passwordInput.fill(password);
        loginButton.click();
    }

    public String verifyTitle() {
        return page.title();
    }

    public boolean isUserNameInputDisplayed() {
        return userNameInput.isVisible();
    }

    public boolean isPasswordInputDisplayed() {
        return passwordInput.isVisible();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isVisible();
    }
}
