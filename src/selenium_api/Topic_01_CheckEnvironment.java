 
package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_CheckEnvironment {
    WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition - Step 01: Init Chrome browser");
		// System.setProperty("webdriver.chrome.driver",".\\libraries\\chromedriver.exe");
		// driver = new ChromeDriver();

		driver = new FirefoxDriver();

		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Pre-condition - Step 03: Open ItViec app url");
		driver.get("https://itviec.com/");
	}

	@Test
	public void TC_01_Check_HomePage_Url() {
		System.out.println("TC_01 - Step 01: Get Current Page Url");
		String homePageUrl = driver.getCurrentUrl();

		System.out.println("TC_01 - Step 02: Verify expected url matching vs actual url");
		Assert.assertEquals(homePageUrl, "https://itviec.com/");
	}

	@Test
	public void TC_02_Check_HomePage_Title() {
		System.out.println("TC_02 - Step 01: Get Current Page Title");
		String homePageTitle = driver.getTitle();

		System.out.println("TC_02 - Step 02: Verify expected title matching vs actual title");
		Assert.assertEquals(homePageTitle, "ITviec | Top IT Jobs for You");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}