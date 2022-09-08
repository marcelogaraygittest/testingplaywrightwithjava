Feature: Sauce Test
  Background:
    Given I launch the SauceLab

  Scenario: Verify page title
    Then I verify the page title is "Swag Labs"

  Scenario: login Page Is Displayed AccordingUx Design
    Then I verify that all components are displayed

  Scenario: mensajeDeErrorEsMostradoCuandoEstanVaciasLosCamposDeUsernameAndPassword
    When I click only login on Login page
    Then I should see error message "Epic sadface: Username is required" on Login page

  Scenario: dashboardDeMuestraDespuesDeLoguearseConUsuarioApropiados
    Given I fill username "standard_user" with "secret_sauce" password on Login page
    When I click login on Login page
    Then I should see the Dashboard page

  Scenario: ProductsAreDisplayedOnCardPageAfterChoosingAnyOfProduct
    Given I fill username "standard_user" with "secret_sauce" password on Login page
    When I click login on Login page
    And I choose the first product on Dashboard page
    And I go to Your Cart page
    Then I should see the "Sauce Labs Backpack" product name

  Scenario: mensajeDeExitoEsMostradDespuesDeHaceElCheckoutDeProduct
    Given I fill username "standard_user" with "secret_sauce" password on Login page
    When I click login on Login page
    And I choose the first product on Dashboard page
    And I go to Your Cart page
    And I checkout, fill information, finish process check complete
    Then I should see the "THANK YOU FOR YOUR ORDER" success message