package stepDefinations;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import edu.testing.playwrighttest.pageobjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AllStepdefs {
    LoginPage login;
    DashboardPage dashboardPage;
    YourCartPage cart;
    CheckoutComplete checkoutComplete;
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    Page page = browser.newPage();

    @Given("I launch the SauceLab")
    public void iLaunchTheSauceLab() {
        login = new LoginPage(page);
        login.navigate();
    }

    @Then("I verify the page title is {string}")
    public void iVerifyThePageTitleIs(String title) {
        Assertions.assertEquals(title, login.verifyTitle());
    }

    @Then("I verify that all components are displayed")
    public void iVerifyThatAllComponentsAreDisplayed() {
        Assertions.assertTrue(login.isUserNameInputDisplayed());
        Assertions.assertTrue(login.isPasswordInputDisplayed());
        Assertions.assertTrue(login.isLoginButtonDisplayed());
    }

    @Given("I fill username {string} with {string} password on Login page")
    public void iFillUsernameWithPasswordOnLoginPage(String username, String password) {
        login.fillingCredentials("standard_user", "secret_sauce");
    }

    @When("I click login on Login page")
    public void iClickLoginOnLoginPage() {
        dashboardPage = login.clickingLoginButton();
    }

    @Then("I should see the Dashboard page")
    public void iShouldSeeTheDashboardPage() {
        Assertions.assertTrue(dashboardPage.isLogoDashboardDisplayed());
    }

    @When("I click only login on Login page")
    public void iClickOnlyLoginOnLoginPage() {
        login.ClickLogin();
    }

    @Then("I should see error message {string} on Login page")
    public void iShouldSeeErrorMessageOnLoginPage(String errorMessage) {
        Assertions.assertEquals("Epic sadface: Username is required", login.GetErrorMessageLogin());
    }

    @Then("I should see the {string} product name")
    public void iShouldSeeTheProductName(String productName) {
        Assertions.assertEquals("Sauce Labs Backpack", cart.GetNameFirstProduct());
    }

    @And("I choose the first product on Dashboard page")
    public void iChooseTheFirstProductOnDashboardPage() {
        dashboardPage.chooseFirstProduct();
    }

    @And("I go to Your Cart page")
    public void iGoToYourCartPage() {
        cart = dashboardPage.goCart();
    }

    @And("I checkout, fill information, finish process check complete")
    public void iCheckoutFillInformationFinishProcessCheckComplete() {
        CheckoutInformationPage checkoutInformationPage = cart.clickCheckout();
        CheckoutOverView checkoutOverView = checkoutInformationPage.fillingInformation("First Name Test", "Last Name Test", "90010");
        checkoutComplete = checkoutOverView.clickFinish();
    }

    @Then("I should see the {string} success message")
    public void iShouldSeeTheSuccessMessage(String sucessMessage) {
        Assertions.assertEquals(sucessMessage, checkoutComplete.getSuccessMessage());
    }
}
