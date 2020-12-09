package tests;

import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test1 extends BaseTest{

    /**
     * Just for testing the framework
     * - Delete this test and the UICatalog.app on resources package
     * - Start building the pages and test of the app
     */
    @Test
    public void pickerView() {
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByXPath("//*[@name='Green color component value']").sendKeys("220");
        driver.findElementByXPath("//*[@name='Red color component value']").sendKeys("55");
        driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");
    }
}
