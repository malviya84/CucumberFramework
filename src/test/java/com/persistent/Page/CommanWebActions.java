package com.persistent.Page;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.SystemClock;

public class CommanWebActions {

	private WebDriver driver;
	private Actions actions;
	private FluentWait<WebDriver> wait;

	public CommanWebActions(WebDriver driver) {
		this.driver = driver;
		// wait = new WebDriverWait(this.driver, 10);
		wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.NANOSECONDS).ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);
		actions = new Actions(this.driver);
	}

	public void waitForPageLoaded(WebDriver driver) {

		// System.out.println("Script is waiting for page load");
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail();
		}
	}

	public boolean WaitUntilWindowWithGivenTitleOpened(String windowTitle, long waitTimeInMilliSecond) {

		long lastTimeInMillisecond = System.currentTimeMillis();
		long currentTimeInMillisecond;
		boolean isWindowFound = false;
		do {
			Set<String> set = driver.getWindowHandles();
			if (set.contains(windowTitle)) {
				isWindowFound = true;
				return isWindowFound;
			}
			currentTimeInMillisecond = System.currentTimeMillis() - lastTimeInMillisecond;
		} while (currentTimeInMillisecond <= waitTimeInMilliSecond);

		return false;
	}

	public void switchToWindowByTitle(String chieldWindowTitle) {
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window))// && child_window.contains(chieldWindowTitle.toString()))
			{
				driver.switchTo().window(child_window);
				// System.out.println(driver.switchTo().window(child_window).getTitle());
				break;
			}
		}

	}

	public void switchToHomePage(String chieldWindowTitle) {
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("set size in home page method " + s1.size());

		Iterator<String> I1 = s1.iterator();

		while (I1.hasNext()) {
			String child_window = I1.next();

			driver.switchTo().window(child_window);
			if (driver.getTitle().equals(chieldWindowTitle)) {
				System.out.println("Current window title = " + driver.getTitle());
				break;
			}

		}
	}

	public void switchToHomePageWindow(String chieldWindowTitle) {
		driver.switchTo().window(chieldWindowTitle);
	}

	public void waitUntilElementIsVisibile(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitUntilElementIsClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void moveMouseToElement(WebElement element) {
		waitUntilElementIsVisibile(element);
		actions.moveToElement(element).build().perform();

	}

	public void performActionClick(WebElement element) {
		waitUntilElementIsVisibile(element);
		actions.moveToElement(element).build().perform();
		actions.click(element);

	}

	public void pageScrollTillElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void pageScrollToTop() {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(100,100)");
	}

	public void closeCurrentWindow() {
		//driver.close();
	}

}
