Feature: Sauce Test


  Scenario: Verify page title
    Given I launch the SauceLab
    Then I verify the page title is "Swag Labs"

#  Scenario: login Page Is Displayed AccordingUx Design
#    Then I verify that all components are displayed
#
#  Scenario: mensajeDeErrorEsMostradoCuandoEstanVaciasLosCamposDeUsernameAndPassword
#    When I click only login on Login page
#    Then I should see the Dashboard page
#
#  Scenario: dashboardDeMuestraDespuesDeLoguearseConUsuarioApropiados
#    Given I fill username "standard_user" with "secret_sauce" password on Login page
#    When I click login on Login page
#    Then I should see the Dashboard page