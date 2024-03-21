package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utilities;

import static pages.OrderRelease.ORDER_RELEASE_PAGE_ELEMENT_XPATHS;
import static pages.Shipment.*;
import static utilities.Iframe.switchToIframe;
import static utilities.Shipment.getOnlyNumbers;
import static utilities.Utilities.*;
import static utilities.WebInteractionsUtils.getElementWithWait;

public class Shipment {
    Actions actions = new Actions(Utilities.getStaticDriver());

    @Then("I switch to {string} page")
    public void switchToShipment(String page) {
        WebElement element = getElementWithWait("orderNumber", ORDER_RELEASE_PAGE_ELEMENT_XPATHS);
        actions.contextClick(element).perform();
        switchToPage(page).click();
    }

    @And("I click on Shipment ID")
    public void clickToShipment() {
        getElementWithWait("shipmentID", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
    }

    @And("I click on shipment Action button")
    public void clickToShipmentActions() {
        getElementWithWait("shipmentActions", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
    }

    @And("I verify status of {string} is = {string}")
    public void verifyStatus(String key, String value) {
        getElementWithWait("status", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
        switchToNewTab();
        verifyStatusOfShipment(key, value);
        switchBackToOriginalTab();
    }

    @Then("I get the distance of last stop")
    public void distanceOfLastStop() {
        double number = getOnlyNumbers(getElementWithWait("D-stopMiles", SHIPMENT_PAGE_ELEMENT_XPATHS));
        Serenity.setSessionVariable("LastStopDistance").to(number);
    }

    @Then("I calculate the shipment cost {double} USD per mile")
    public void calculateTheDistance(double usd) {
        double baseCost = getOnlyNumbers(getElementWithWait("baseCost", SHIPMENT_PAGE_ELEMENT_XPATHS));

        double miles = Serenity.sessionVariableCalled("LastStopDistance");
        double finalCost = usd * miles;

        Assert.assertEquals("The calculated final cost does not match the base cost.", baseCost, finalCost, 0.01);
    }

    @Then("I verify {string} is = {string}")
    public void verifyTerminal(String terminal, String terminalID) {
        Assert.assertEquals(getElementWithWait(terminal, SHIPMENT_PAGE_ELEMENT_XPATHS).getText(), terminalID);
    }

    @And("I assign the {string} driver")
    public void assignTheDriver(String driverID) throws InterruptedException {
        getElementWithWait("fleetManagement", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
        getElementWithWait("assign", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
        getElementWithWait("driver", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
        switchToNewTab();
        switchToIframe("mainBody");
        getElementWithWait("assignEquipmentTypeForShipment", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
        getElementWithWait("dropEmptyBeforeFreightCheckbox", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
        getElementWithWait("driverIDInput", SHIPMENT_PAGE_ELEMENT_XPATHS).sendKeys(getSecret(driverID));
        getElementWithWait("okButton", SHIPMENT_PAGE_ELEMENT_XPATHS).click();
        Thread.sleep(5000);
        switchBackToOriginalTab();
    }
}
