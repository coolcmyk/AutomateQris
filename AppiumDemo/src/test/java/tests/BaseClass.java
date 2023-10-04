package tests;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12 SP1A.210812.016");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 9");
            caps.setCapability(MobileCapabilityType.UDID, "c1106a890403");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            caps.setCapability(MobileCapabilityType.APP, "");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "CHROME");
            
            URI uri = new URI("http://172.30.144.1:4723/");
            URL url = uri.toURL();
            
            driver = new RemoteWebDriver(url, caps);
        } catch(Exception exp) {
            System.out.println("Error in setup: " + exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }
    
    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        } else {
            System.out.println("Driver is null, cannot close and quit.");
        }
    }
}
