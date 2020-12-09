package driver;

import Utils.NeimanUtils;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class Capabilities {

    private DesiredCapabilities cap;

    public Capabilities() throws IOException {
        cap= new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, NeimanUtils.getPropertyFile("DEVICE_NAME"));
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, NeimanUtils.getPropertyFile("PLATFORM_NAME"));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, NeimanUtils.getPropertyFile("PLATFORM_VERSION"));
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability(MobileCapabilityType.UDID, NeimanUtils.getPropertyFile("UDID"));
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,NeimanUtils.getPropertyFile("NEW_COMMAND_TIMEOUT"));
        cap.setCapability(MobileCapabilityType.APP,getAPP().getAbsolutePath());
        System.out.println(cap);
    }

    public DesiredCapabilities getCapabilities(){
        return this.cap;
    }

    private File getAPP() throws IOException {
        File resourcesPath= new File("src/main/resources/");
        File app= new File(resourcesPath,NeimanUtils.getPropertyFile("APP")); //iOS APP Name from Capabilities.properties
        return app;
    }



}
