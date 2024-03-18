Feature: Upload XML from Integration Manager workflow

  I want to ensure that orders can be processed using Integration Manager within the OTM system

  @xml @xml-generate @PICKLOADED-DROPLOADED-ODR
  Scenario: Generate XML for creating an order (PICKLOADED-DROPLOADED-ODR) with equipment assigned
    Given Read xml for the following "PICKLOADED-DROPLOADED-ODR"
    When I updated Order_Release_ID in this xml
    And I updated Pickup and Delivery dates to actual
    And I updated Equipment_ID in this xml
    Then I save modified xml
    And I update "config" .properties file

  @xml @xml-generate @LIVELOADED-DROPLOADED-ODR
  Scenario: Generate XML for creating an order (LIVELOADED-DROPLOADED-ODR)
    Given Read xml for the following "LIVELOADED-DROPLOADED-ODR"
    When I updated Order_Release_ID in this xml
    And I updated Pickup and Delivery dates to actual
    Then I save modified xml
    And I update "config" .properties file

  @xml @xml-upload
  Scenario: Upload XML order from Integration Manager
    Given I am logged in to the Order Tracking Management system
    And I change the role to "ADMIN"
    When I am on the "Integration Manager" page
    And I am on the Upload an XML-CSV Transmission page
    Then I upload "PICKLOADED-DROPLOADED-ODR" xml
    Then I upload "LIVELOADED-DROPLOADED-ODR" xml