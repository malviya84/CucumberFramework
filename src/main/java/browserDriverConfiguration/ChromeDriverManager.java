package browserDriverConfiguration;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager  {
	
	private ChromeDriverService chService;

   
    public void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(System.getProperty("user.dir")+"//DriverExecutable//chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

  
    public void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

	// public WebDriver getDriver() {
    public void createDriver() {	
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("test-type");
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        driver = new ChromeDriver(chService, capabilities);
    }

}
