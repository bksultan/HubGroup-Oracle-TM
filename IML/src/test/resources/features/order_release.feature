@TC-003 @TC-004
Feature: End-to-End Workflow for Order Release ID Processing

  I want to ensure that orders created

  Background: : Login to OTM
    Given I am logged in to the Order Tracking Management system

  Scenario: PICKLOADED-DROPLOADED-ODR Order Release ID flow
    When I am on the "Order Release" page
    And I enter the order type "PICKLOADED-DROPLOADED-ODR" into the search field
    And I click on the Search button
    Then I click on Order number
    And I verify order reference numbers
    When I switch to "Other Attributes" tab
    Then I verify SS "PICKLOADED"
    Then I verify SS "DROPLOADED"

  Scenario: LIVELOADED-DROPLOADED-ODR Order Release ID flow
    When I am on the "Order Release" page
    And I enter the order type "LIVELOADED-DROPLOADED-ODR" into the search field
    And I click on the Search button
    Then I click on Order number
    And I verify order reference numbers
    When I switch to "Other Attributes" tab
    Then I verify SS "DROPLOADED"