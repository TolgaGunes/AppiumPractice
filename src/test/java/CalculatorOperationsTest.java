import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorOperationsTest {
    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel3");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        // set the URL for Appium Server
        URL url = new URL("http://localhost:4723/wd/hub");

        // launch Appium Driver
        driver = new AndroidDriver<MobileElement>(url, capabilities);

    }

    /**
     * 4 + 5 = 9
     */

    @Test
    public void addTest() {
        //locate 4,plus,5, equals, and result
        MobileElement four = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        four.click();
        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        plus.click();

        MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        four.click();

        MobileElement equal = driver.findElement(MobileBy.AccessibilityId("equals"));
        equal.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
        String actualResult = result.getText();
        System.out.println("actualResult = " + actualResult);

        int expResult = 9;

        Assertions.assertEquals(expResult, Integer.parseInt(actualResult));
    }

    @Test
    public void divideTest() {
        MobileElement one = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        one.click();

        MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        five.click();

        MobileElement divide = driver.findElement(MobileBy.AccessibilityId("divide"));
        divide.click();

        five.click();

        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        String actualResult = result.getText();
        System.out.println("actualResult = " + actualResult);

        int expResult = 3;

        Assertions.assertEquals(expResult, Integer.parseInt(actualResult));

    }

    @AfterEach
    public  void cleanUp() {
        driver.closeApp();
    }

}
