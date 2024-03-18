package utilities;

import org.junit.Assert;

import static pages.OrderRelease.ORDER_RELEASE_PAGE_ELEMENT_XPATHS;
import static utilities.WebInteractionsUtils.getElement;

public class OrderRelease {
    public static void ssVerify(String order) {
        switch (order) {
            case "PICKLOADED":
                Assert.assertTrue(getElement("PICKLOADED", ORDER_RELEASE_PAGE_ELEMENT_XPATHS).isDisplayed());
                break;
            case "DROPLOADED":
                Assert.assertTrue(getElement("DROPLOADED", ORDER_RELEASE_PAGE_ELEMENT_XPATHS).isDisplayed());
                break;
            case "LIVELOADED":
                Assert.assertTrue(getElement("LIVELOADED", ORDER_RELEASE_PAGE_ELEMENT_XPATHS).isDisplayed());
                break;
            case "LIVEUNLOADED":
                Assert.assertTrue(getElement("LIVEUNLOADED", ORDER_RELEASE_PAGE_ELEMENT_XPATHS).isDisplayed());
                break;
        }
    }
}
