package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CalculatorPage {
    public CalculatorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
}
