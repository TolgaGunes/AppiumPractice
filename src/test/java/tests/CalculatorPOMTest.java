package tests;

import org.junit.jupiter.api.Test;
import pages.CalculatorPage;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorPOMTest {

    CalculatorPage calculatorPage = new CalculatorPage();

    @Test
    public void multiplyTest() {
        calculatorPage.clickDigit(5);
        calculatorPage.multiply.click();
        calculatorPage.clickDigit(8);
        calculatorPage.equals.click();
        String  result = calculatorPage.result.getText();
        System.out.println("result: " + result);

        assertEquals(40, Integer.parseInt(result));
    }


}
