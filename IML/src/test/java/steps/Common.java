package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

import static pages.Home.HOME_PAGE_ELEMENT_XPATHS;
import static pages.Login.LOGIN_PAGE_ELEMENT_XPATHS;
import static pages.TileLinks.getLink;
import static utilities.Iframe.switchToIframe;
import static utilities.Utilities.getSecret;
import static utilities.WebInteractionsUtils.*;

public class Common extends PageObject {
    private EnvironmentVariables environmentVariables;

    @Given("I am logged in to the Order Tracking Management system")
    public void loginToOtm() {
        openAt(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("otm.base.url"));
        getDriver().manage().window().maximize();

        getElementWithWait("username", LOGIN_PAGE_ELEMENT_XPATHS).sendKeys(getSecret("username"));
        getElementWithWait("password", LOGIN_PAGE_ELEMENT_XPATHS).sendKeys(getSecret("password"));
        getElementWithWait("signInBtn", LOGIN_PAGE_ELEMENT_XPATHS).click();
    }

    @Given("I am logged in to the HubPro as IC {string} driver tablet")
    public void loginToHubPro(String driver) {
        openAt(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("hubpro.base.url"));
        getDriver().manage().window().maximize();

        getElementWithWait("hubProUsername", LOGIN_PAGE_ELEMENT_XPATHS).sendKeys(driver);
        getElementWithWait("hubProPassword", LOGIN_PAGE_ELEMENT_XPATHS).sendKeys(getSecret(driver + "Password"));
        getElementWithWait("hubProSignInBtn", LOGIN_PAGE_ELEMENT_XPATHS).click();
    }

    @Given("I change the role to {string}")
    public void changeRole(String role) throws InterruptedException {
        userRoleChange(role);
    }

    @When("I am on the {string} page")
    public void openLink(String option) throws InterruptedException {
        openAt(getLink(option));
    }

    @And("I switch to {string} Iframe")
    public void switchToMainIframe(String iframe) {
        switchToIframe(iframe);
    }

    @And("I switch to Default Iframe")
    public void switchToDefaultIframe() {
        switchToDefaultIframe();
    }


    @When("I am on the Integration Manager page")
    public void searchBy() {
        clickWithJS(getXpath("homeBtn", HOME_PAGE_ELEMENT_XPATHS));
        clickWithJS(getXpath("navigatorButton", HOME_PAGE_ELEMENT_XPATHS));
        clickWithJS(getXpath("Integration", HOME_PAGE_ELEMENT_XPATHS));
        clickWithJS(getXpath("IntegrationManager", HOME_PAGE_ELEMENT_XPATHS));
    }

}
