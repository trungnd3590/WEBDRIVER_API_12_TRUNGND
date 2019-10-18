package selenium_api;

import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Topic_15_Selenium_WebDriver_Wait {

	WebDriver driver;
	WebDriverWait explicitWait;
	FluentWait<WebElement> fluentWait;

	By startBtnX = By.xpath("//div[@id='start']/button");
	By loadingX = By.xpath("//div[@id='loading']");
	By resultTxtX = By.xpath("//div[@id='finish']/h4");

	By todayClickX = By.xpath("//a[text()='14']");
	By loadingIconX = By.xpath("//div[@class='raDiv']");
	By selectedDateX = By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']");

	By fluentWaitX = By.xpath("//div[@id='javascript_countdown_time']");

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");
		driver = new FirefoxDriver();
		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_Implicit_Wait() throws Exception {

		String pageUrl = "http://the-internet.herokuapp.com/dynamic_loading/2";

		System.out.println("TC01 : 1. Accces to Page : " + pageUrl);
		driver.get(pageUrl);

		System.out.println("TC01 : 2. Click Start Button");
		driver.findElement(startBtnX).click();

		System.out.println("TC01 : 3. Wait until Result Text Appear ");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("TC01 : 4. Result Text Displayed Status : " + driver.findElement(resultTxtX).isDisplayed());

		System.out.println("TC01 : 5. Result Text : " + driver.findElement(resultTxtX).getText());
	}

	@Test
	public void TC02_Explicit_Wait_Invisible() throws Exception {

		String pageUrl = "http://the-internet.herokuapp.com/dynamic_loading/2";

		explicitWait = new WebDriverWait(driver, 5);

		System.out.println("TC02 : 1. Accces to Page : " + pageUrl);
		driver.get(pageUrl);

		System.out.println("TC02 : 2. Click Start Button");
		driver.findElement(startBtnX).click();

		System.out.println("TC02 : 3. Wait until Result Text Appear ");

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingX));

		System.out.println("TC02 : 4. Result Text Displayed Status : " + driver.findElement(resultTxtX).isDisplayed());

		System.out.println("TC02 : 5. Result Text : " + driver.findElement(resultTxtX).getText());

	}

	@Test
	public void TC03_Explicit_Wait_Visible() {

		String pageUrl = "http://the-internet.herokuapp.com/dynamic_loading/2";

		explicitWait = new WebDriverWait(driver, 5);

		System.out.println("TC03 : 1. Accces to Page : " + pageUrl);
		driver.get(pageUrl);

		System.out.println("TC03 : 2. Click Start Button");
		driver.findElement(startBtnX).click();

		System.out.println("TC03 : 3. Wait until Result Text Appear ");

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(resultTxtX));

		System.out.println("TC03 : 4. Result Text Displayed Status : " + driver.findElement(resultTxtX).isDisplayed());

		System.out.println("TC03 : 5. Result Text : " + driver.findElement(resultTxtX).getText());
	}

	@Test
	public void TC04_Explicit_Wait() {

		String pageUrl = "http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx";

		explicitWait = new WebDriverWait(driver, 5);

		System.out.println("TC04 : 1. Accces to Page : " + pageUrl);
		driver.get(pageUrl);

		System.out.println("TC04 : 2. Click to select Date ");
		driver.findElement(todayClickX).click();

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIconX));

		System.out.println("TC04 : 3. Date is Selected : " + driver.findElement(selectedDateX).getText());

	}

	@Test
	public void TC05_Fluent_Wait() {

		String pageUrl = "https://automationfc.github.io/fluent-wait/";

		System.out.println("TC05 : 1. Accces to Page : " + pageUrl);
		driver.get(pageUrl);

		WebElement coundownTimer = driver.findElement(fluentWaitX);

		explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.visibilityOf(coundownTimer));

		fluentWait = new FluentWait<WebElement>(coundownTimer);

		fluentWait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {

						boolean flag = element.getText().endsWith("02");
						System.out.println("Timer : " + element.getText());

						return flag;
					}

				});

	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
