package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static utilities.Utilities.getSecret;
import static utilities.WebInteractionsUtils.getElementWithWait;
import static utilities.WebInteractionsUtils.getStaticDriver;

public class Login extends PageObject {
    public static final Map<String, String> LOGIN_PAGE_ELEMENT_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();

        map.put("username", "//input[@id='idcs-signin-basic-signin-form-username']");
        map.put("password", "//input[@id='idcs-signin-basic-signin-form-password|input']");
        map.put("signInBtn", "//*[@id='idcs-signin-basic-signin-form-submit']/button");

        map.put("hubProUsername", "//input[@id='input-username']");
        map.put("hubProPassword", "//input[@id='input-password']");
        map.put("hubProSignInBtn", "//input[@id='button-login']");

        return Collections.unmodifiableMap(map);
    }
}
