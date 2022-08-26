package edu.testing.playwrighttest.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator userNameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator BurgerMenuButton;
    private final Locator ErrorMessageLogin;


    public LoginPage(Page page) {
        this.page = page;
        this.userNameInput = page.locator("[Placeholder=Username]");
        this.passwordInput = page.locator("[Placeholder=Password]");
        this.loginButton = page.locator("#login-button");
        this.BurgerMenuButton = page.locator("#react-burger-menu-btn");
        this.ErrorMessageLogin = page.locator("h3[data-test='error']");
    }

    public void navigate() {
        page.navigate("https://www.saucedemo.com/");
    }

    public DashboardPage fillingLogin(String userName, String password) {
        userNameInput.fill(userName);
        passwordInput.fill(password);
        ClickLogin();
        return new DashboardPage(this.page);
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

    public boolean isLogoutDisplayed() {
        return BurgerMenuButton.isVisible();
    }

    public void logoutSession() {
        LeftPanelPage leftPanelPage = expandLeftPanel();
        leftPanelPage.clickLogout();
    }

    public LeftPanelPage expandLeftPanel() {
        BurgerMenuButton.click();
        return new LeftPanelPage(this.page);
    }

    public void ClickLogin() {
        loginButton.click();
    }

    public String GetErrorMessageLogin() {
        return ErrorMessageLogin.innerText();
    }
}
