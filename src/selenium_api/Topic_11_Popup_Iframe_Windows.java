package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_11_Popup_Iframe_Windows {

	WebDriver driver;

	By popupBannerX = By.xpath("//img[contains(@class,'popupbanner')]");
	By popupCloseX = By.xpath("//img[@class='popupCloseButton']");
	By rightBannerX = By.xpath("//div[@id='rightbanner']//img");
	By flipBannerX = By.xpath("//div[@class='flipBanner'] //img[@class='front icon']");
	By loginFrameX = By.xpath("//frame[@name='login_page']");
	By footerFrameX = By.xpath("//frame[@name='footer']");
	By loginTxtX = By.xpath("//input[@name='fldLoginUserId']");
	By continueloginBtnX = By.xpath("//table[@class='lForm']//img");
	By passTxtX = By.xpath("//input[@name='fldPassword']");
	By privacyX = By.xpath("//a[text()='Privacy Policy']");

	By googleLinkX = By.xpath("//a[text()='GOOGLE']");
	By facebookLinkX = By.xpath("//a[text()='FACEBOOK']");
	By tikiLinkX = By.xpath("//a[text()='TIKI']");

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");

		driver = new FirefoxDriver();
		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_Handle_PopUp_IFrame() throws Exception {

		String pageUrl01 = "https://www.hdfcbank.com/";
		String pageUrl02 = "https://netbanking.hdfcbank.com/netbanking";

		driver.get(pageUrl01);

		WebElement popupBanner = driver.findElement(popupBannerX);

		if (popupBanner.isDisplayed() == true) {
			WebElement closePopup = driver.findElement(popupCloseX);
			closePopup.click();
			System.out.println("TC01 : 1. Closed pop-up Banner !!!");
		} else {
			System.out.println("TC01 : 1. Pop-up Banner did Not Show Up !!!");
		}

		Thread.sleep(2000);

		List<WebElement> rightBannerImg = driver.findElements(rightBannerX);
		if (rightBannerImg.size() == 7) {
			System.out.println("TC01 : 2. Right Banner has " + rightBannerImg.size() + " Images !!!");
		} else {
			System.out.println("TC01 : 2. Right Banner has " + rightBannerImg.size() + " Images !!!");
		}

		Thread.sleep(2000);

		List<WebElement> flipBanner = driver.findElements(flipBannerX);
		for (WebElement flipImg : flipBanner) {
			int i = 1;
			if (flipImg.isDisplayed() == true) {
				System.out.println("TC01 : 3. Image " + i + " is Displayed !!!");
			} else {
				System.out.println("TC01 : 3. Image " + i + " is NOT Displayed !!!");
			}
			i++;
		}

		Thread.sleep(2000);

		if (flipBanner.size() == 8) {
			System.out.println("TC01 : 4. Flip Banner has " + flipBanner.size() + " Images !!!");
		} else {
			System.out.println("TC01 : 4. Right Banner has " + flipBanner.size() + " Images !!!");
		}

		Thread.sleep(2000);

		driver.get(pageUrl02);
		Thread.sleep(2000);

		WebElement loginFrame = driver.findElement(loginFrameX);
		driver.switchTo().frame(loginFrame);

		driver.findElement(loginTxtX).sendKeys("selenium_online");
		driver.findElement(continueloginBtnX).click();

		Thread.sleep(2000);

		WebElement passTxt = driver.findElement(passTxtX);
		if (passTxt.isDisplayed() == true) {
			System.out.println("TC01 : 5. Password field is Displayed !!!");
		} else {
			System.out.println("TC01 : 5. Password field is NOT Displayed !!!");
		}

		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		WebElement footerFrame = driver.findElement(footerFrameX);
		driver.switchTo().frame(footerFrame);

		WebElement privacy = driver.findElement(privacyX);
		if (privacy.isDisplayed() == true) {
			System.out.println("TC01 : 6. Privacy Policy Link is Displayed !!!");
		} else {
			System.out.println("TC01 : 6. Privacy Policy Link is NOT Displayed !!!");
		}

	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
