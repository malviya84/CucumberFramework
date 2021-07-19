package browserDriverConfiguration;

import enums.BrowserDriver;

public class DriverManagerFactory {

	private static ChromeDriverManager chromeDriver = null;

	private static FirefoxDriverManager fireDriver = null;

	public static DriverManager getManager(BrowserDriver browserDriverType) {
		if (browserDriverType == BrowserDriver.CHROME) {
			if (chromeDriver == null) {
				chromeDriver = new ChromeDriverManager();
				return chromeDriver;
			} else
				return chromeDriver;
		} else if (browserDriverType == BrowserDriver.FIREFOX) {
			if (fireDriver == null) {
				fireDriver = new FirefoxDriverManager();
				return fireDriver;
			} else
				return fireDriver;
		}
		return null;
	}
}
