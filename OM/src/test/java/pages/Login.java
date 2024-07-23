package pages;

import net.serenitybdd.core.pages.PageObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Login extends PageObject {
    public static final Map<String, String> LOGIN_PAGE_ELEMENT_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();

        map.put("username", "//input[@id='userNameInput']");
        map.put("password", "//input[@id='passwordInput']");
        map.put("signInBtn", "//span[@id='submitButton']");

        map.put("microsoftStaySignedIn", "//input[@id='idSIButton9']");

        return Collections.unmodifiableMap(map);
    }
}
