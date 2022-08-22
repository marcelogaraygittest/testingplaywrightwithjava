package edu.testing.playwrighttest.tests;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void launchBrowser(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));;
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com/");
            System.out.println(page.title());
            page.type("[Placeholder=Username]", "standard_user");
            page.type("[Placeholder=Password]", "secret_sauce");
            page.click("#login-button");
        }
    }
}
