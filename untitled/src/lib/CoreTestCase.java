package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URI;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String appiumURL = "http://127.0.0.1:4723/";


        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "OPPO A78");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("app", "C:\\Users\\artem\\IdeaProjects\\new_try\\untitled\\apks\\org.wikipedia.apk");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");

        driver = new AndroidDriver(new URI(appiumURL).toURL(), capabilities);
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
}
