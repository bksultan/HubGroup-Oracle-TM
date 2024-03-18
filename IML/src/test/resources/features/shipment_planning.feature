Feature: End-to-End Workflow for PICKLOAD-ODR Order Processing

  I want to ensure that orders created

  @TC-003 @TC-004 @TC-006 @TC-008 @TC-010 @TC-011
  Scenario: Order/shipment verification
    Given I am logged in to the Order Tracking Management system
    When I am on the "Order Release" page
    And I enter the order type "PICKLOADED-DROPLOADED-ODR" into the search field
    And I click on the Search button
    Then I switch to "Related Buy Shipments" page
    And I click on Shipment ID
    And I verify status of "WORK_INVOICE_GENERATION" is = "WORK_INVOICE_GENERATION_NOT_STARTED"
    And I switch to "mainIFrameStr" Iframe
    And I verify shipment reference numbers
    When I switch to "Stops" tab
    Then I get the distance of last stop
    When I switch to "Financials" tab
    And I calculate the shipment cost 1 USD per mile
    Then I verify SS "PICKLOADED"
    Then I verify SS "DROPLOADED"
    Then I verify SS "MOVE_EMPTY"
    When I switch to "Involved Parties" tab
    Then I verify "TERMINAL" is = "TERMINAL_TXMESQUITE_0078"
    Then I verify "EXECUTING_TERMINAL" is = "TERMINAL_TXMESQUITE_0078"

  @TC-014
  Scenario: Assign driver to the shipment
    Given I am logged in to the Order Tracking Management system
    When I am on the "Order Release" page
    And I enter the order type "PICKLOADED-DROPLOADED-ODR" into the search field
    And I click on the Search button
    Then I switch to "Related Buy Shipments" page
    And I click on shipment Action button
    And I switch to "actionFrame" Iframe
    And I assign the "EMDAVIS" driver

  @TC-014
  Scenario: Complete shipment from HubPRO
    Given I am logged in to the HubPro as IC "EMDAVIS" driver tablet
    When I switch to "preplans" tab in tablet
    Then I accept new shipments
    And I activate shipment
    And I start execute "Bobtail" stop detail of the shipment