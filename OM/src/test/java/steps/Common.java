package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

import static pages.Home.HOME_PAGE_ELEMENT_XPATHS;
import static pages.Login.LOGIN_PAGE_ELEMENT_XPATHS;
import static utilities.Utilities.getSecret;
import static utilities.WebInteractionsUtils.getElementWithWait;

public class Common extends PageObject {
    private EnvironmentVariables environmentVariables;

    @Given("I am logged in to the Order Management system")
    public void loginToOM() throws InterruptedException {
        openAt(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("om.base.url"));
        getDriver().manage().window().maximize();

        getElementWithWait("username", LOGIN_PAGE_ELEMENT_XPATHS).sendKeys(getSecret("username"));
        getElementWithWait("password", LOGIN_PAGE_ELEMENT_XPATHS).sendKeys(getSecret("password"));
        getElementWithWait("signInBtn", LOGIN_PAGE_ELEMENT_XPATHS).click();

        getElementWithWait("microsoftStaySignedIn", LOGIN_PAGE_ELEMENT_XPATHS).click();
    }

    @Given("I am at {string} page")
    public void orderEntryPage(String page) throws InterruptedException {
        getElementWithWait(page, HOME_PAGE_ELEMENT_XPATHS).click();
        getElementWithWait("createDropDownMenu", HOME_PAGE_ELEMENT_XPATHS).click();
        getElementWithWait("createNewOrderButton", HOME_PAGE_ELEMENT_XPATHS).click();
        Thread.sleep(5000);
    }

}
