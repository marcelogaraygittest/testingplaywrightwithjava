package edu.testing.playwrighttest.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import edu.testing.playwrighttest.pageobjects.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginPageTest {
    LoginPage login;
    DashboardPage dashboardPage;
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    Page page = browser.newPage();

    @BeforeAll
    public void setUp() {
        login = new LoginPage(page);
        login.navigate();
    }
    @AfterEach
    public void afterRunEachTestCase() {
        if(login.isLogoutDisplayed())
        {
            login.logoutSession();
        }
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

    @Test
    public void mensajDeErrorEsMostradoCuandoEstanVaciasLosCamposDeUsernameAndPassword(){
        login.ClickLogin();

        Assertions.assertEquals("Epic sadface: Username is required", login.GetErrorMessageLogin());
    }

    @Test
    public void dashboardDeMuestraDespuesDeLoguearseConUsuarioApropiados(){
        dashboardPage = login.fillingLogin("standard_user", "secret_sauce");

        Assertions.assertTrue(dashboardPage.isLogoDashboardDisplayed());
    }

    @Test
    public void ProductsAreDisplayedOnCardPageAfterChoosingAnyOfProduct(){
        dashboardPage = login.fillingLogin("standard_user", "secret_sauce");
        dashboardPage.chooseFirstProduct();
        YourCartPage cart = dashboardPage.goCart();
        Assertions.assertEquals("Sauce Labs Backpack", cart.GetNameFirstProduct());
    }

    @Test
    public void mensajeDeExitoEsMostradDespuesDeHaceElCheckoutDeProduct(){
        dashboardPage = login.fillingLogin("standard_user", "secret_sauce");
        dashboardPage.chooseFirstProduct();
        YourCartPage cart = dashboardPage.goCart();
        CheckoutInformationPage checkoutInformationPage = cart.clickCheckout();
        CheckoutOverView checkoutOverView = checkoutInformationPage.fillingInformation("First Name Test", "Last Name Test", "90010");
        CheckoutComplete checkoutComplete = checkoutOverView.clickFinish();
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", checkoutComplete.getSuccessMessage());
    }
}
