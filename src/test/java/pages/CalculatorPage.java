package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CalculatorPage {
    public CalculatorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(accessibility = "equals")
    public MobileElement equals;

    @AndroidFindBy(accessibility = "multiply")
    public MobileElement multiply;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public MobileElement result;

    public void multiply() {
        multiply.click();
    }

    public void clickDigit(int digit) {
        String id = "com.google.android.calculator:id/digit_" + digit;
        MobileElement number = Driver.getDriver().findElement(By.id(id));
        number.click();
    }
}
