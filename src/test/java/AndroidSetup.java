import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by suci on 4/4/17.
 */

public class AndroidSetup {

    public AndroidDriver driver;

    public void androidSetUpAppium() throws MalformedURLException {
        File app = new File("/opt/apks","athena-sample.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", "com.naspers_classifieds.loginsample");
        capabilities.setCapability("appActivity", "com.naspers_classifieds.loginsample.MainActivity");
        capabilities.setCapability("appWaitActivity", "com.naspers_classifieds.loginsample.MainActivity");

        capabilities.setCapability("deviceName","Galaxy");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("newCommandTimeout", 60 * 5);
        // capabilities.setCapability("udid", udid);

        //No Reset Apps
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", true);

        //No Keyboard Layout
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("locationContextEnabled", "true");
        capabilities.setCapability("deviceReadyTimeout", 100);
        capabilities.setCapability("appWaitDuration", 1000000);

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);

    }

    private void checkEligibleRun() throws Exception {
        SessionId sessionId = driver.getSessionId();
        boolean isappinst = driver.isAppInstalled("com.naspers_classifieds.loginsample");
        if(sessionId == null && isappinst == false){
            System.exit(1);
        }
    }

    @BeforeClass
    public void setUp() throws Exception {
        androidSetUpAppium();
        checkEligibleRun();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
