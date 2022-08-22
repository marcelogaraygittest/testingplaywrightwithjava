package edu.testing.playwrighttest.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import edu.testing.playwrighttest.pageobjects.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginPageTest {
    LoginPage login;
    Playwright playwright = Playwright.create();
    //BrowserType firefox = playwright.firefox();

//    Browser browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    Page page = browser.newPage();

    @BeforeAll
    public void setUp() {
        login = new LoginPage(page);
        login.navigate();
    }

    @Test
    public void verifyPageTitle() {
        String title = login.verifyTitle();
        Assertions.assertEquals(title, "Swag Labs");
    }

    @Test
    public void loginPageIsDisplayedAccordingUxDesign(){
        Assertions.assertTrue(login.isUserNameInputDisplayed());
        Assertions.assertTrue(login.isPasswordInputDisplayed());
        Assertions.assertTrue(login.isLoginButtonDisplayed());
    }


//        login.fillingLogin("standard_user", "secret_sauce");
}
