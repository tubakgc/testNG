import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class MultipleTests {
    @Test(priority = 3)
    public void openYoutube() {
        Driver.getDriver().get("https://www.youtube.com/");
        System.out.println("Youtube sayfası açıldı.");
        assertTrue(true);
    }

    @Test(priority = 2)
    public void openAmazon() {
        Driver.getDriver().get("https://www.amazon.com/");
        System.out.println("Amazon sayfası açıldı.");
        assertTrue(true);
    }

    @Test(enabled = false)
    public void openAliexpress() {
        Driver.getDriver().get("https://www.aliexpress.com");
        System.out.println("Aliexpress sayfası açıldı");
        assertTrue(true);
    }

    @Test(priority = 1, dependsOnMethods = "openYoutube")
    public void openFacebook() {
        Driver.getDriver().get("https://www.facebook.com");
        System.out.println("facebook sayfası açıldı");
        assertTrue(true);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
