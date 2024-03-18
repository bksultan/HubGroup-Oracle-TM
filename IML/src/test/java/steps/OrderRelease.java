package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.OrderRelease.ORDER_RELEASE_PAGE_ELEMENT_XPATHS;
import static pages.OrderRelease.requiredOrderRefnumIsExist;
import static pages.Shipment.requiredShipmentRefnumIsExist;
import static utilities.OrderRelease.ssVerify;
import static utilities.Utilities.getProperty;
import static utilities.WebInteractionsUtils.*;

public class OrderRelease {
    @And("I enter the order type {string} into the search field")
    public void using_by(String orderType) {
        getElementWithWait("orderReleaseIDInput", ORDER_RELEASE_PAGE_ELEMENT_XPATHS).sendKeys(getProperty(orderType));
    }

    @Then("I click on Order number")
    public void click_on() {
        getElementWithWait("orderNumber", ORDER_RELEASE_PAGE_ELEMENT_XPATHS).click();
    }

    @When("I switch to {string} tab")
    public void switchToTab(String tab) {
        getElement(tab, ORDER_RELEASE_PAGE_ELEMENT_XPATHS).click();
    }

    @And("I verify order reference numbers")
    public void refnums() {
        requiredOrderRefnumIsExist();
    }

    @And("I verify shipment reference numbers")
    public void shipmentRefnums() {
        requiredShipmentRefnumIsExist();
    }

    @And("I click on the Search button")
    public void searchButton() {
        getElementWithWait("searchBtn", ORDER_RELEASE_PAGE_ELEMENT_XPATHS).click();
    }

    @Then("I verify SS {string}")
    public void verifySS(String order){
        ssVerify(order);
    }
}
