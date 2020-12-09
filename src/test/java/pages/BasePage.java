package pages;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected MobileDriver driver;

    protected BasePage(MobileDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
}
