package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_11_Popup_Iframe_Windows {

	WebDriver driver;

	By popupBannerX = By.xpath("//img[contains(@class,'popupbanner')]");
	By popupCloseX = By.cssSelector(".popupCloseButton");
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

	By ariLinkX = By.xpath("//a[text()='Agri']");
	By accDetailsLinkX = By.xpath("//p[text()='Account Details']");
	By fbFooterX = By.xpath("//a[@class='facebook']");

	By mobileTabX = By.xpath("//a[text()='Mobile']");
	By sonyCompareX = By.xpath(
			"//a[@title='Sony Xperia']/parent::h2//following-sibling::div[@class='actions']//a[@class='link-compare']");
	By samsungCompareX = By.xpath(
			"//a[@title='Samsung Galaxy']/parent::h2//following-sibling::div[@class='actions']//a[@class='link-compare']");
	By successMsgX = By.xpath("//li[@class='success-msg']//span");
	By compareBtnX = By.xpath("//button[@title='Compare']");

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

	@Test
	public void TC02_Handle_Window_Tab() throws Exception {

		String pageUrl = "https://automationfc.github.io/basic-form/index.html";
		driver.get(pageUrl);
		String parentWindowsID = driver.getWindowHandle();

		System.out.println("TC02 : 1. Click GOOGLE Link and Verify :");
		driver.findElement(googleLinkX).click();
		switchToWindowByTitle("Google");
		verifyWindowsTitle("Google");

		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");

		System.out.println("TC02 : 2. Click FACEBOOK Link and Verify :");
		driver.findElement(facebookLinkX).click();
		switchToWindowByTitle("Facebook - Đăng nhập hoặc đăng ký");
		verifyWindowsTitle("Facebook - Đăng nhập hoặc đăng ký");

		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");

		System.out.println("TC02 : 3. Click TIKI Link and Verify :");
		driver.findElement(tikiLinkX).click();
		switchToWindowByTitle("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
		verifyWindowsTitle("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");

		System.out.println("TC02 : 4. Close All Windows Except Parent WWindows and Verify :");
		closeAllWindowsExceptParentWindows(parentWindowsID);
		verifyWindowsTitle("SELENIUM WEBDRIVER FORM DEMO");

	}

	@Test
	public void TC03_Handle_Windows_Tab_Frame() throws Exception {

		String pageUrl = "http://www.hdfcbank.com/";
		driver.get(pageUrl);
		String parentWindowsID = driver.getWindowHandle();

		WebElement popupBanner = driver.findElement(popupBannerX);

		if (popupBanner.isDisplayed() == true) {
			WebElement closePopup = driver.findElement(popupCloseX);
			closePopup.click();
			System.out.println("TC03 : Closed pop-up Banner !!!");
		} else {
			System.out.println("TC03 : Pop-up Banner did Not Show Up !!!");
		}

		Thread.sleep(2000);

		System.out.println("TC03 : 1. Switch to Agri Link ");
		driver.findElement(ariLinkX).click();
		switchToWindowByTitle("HDFC Bank Kisan Dhan Vikas e-Kendra ");

		System.out.println("TC03 : 2. Switch to Account Details Link ");
		driver.findElement(accDetailsLinkX).click();
		switchToWindowByTitle("Welcome to HDFC Bank NetBanking");

		System.out.println("TC03 : 3. Click Privacy Link in Footer");
		WebElement footerFrame = driver.findElement(footerFrameX);
		driver.switchTo().frame(footerFrame);

		driver.findElement(privacyX).click();
		switchToWindowByTitle("Privacy");

		System.out.println("TC03 : 4. Click Facebook Link in Footer");
		switchToWindowsByID(parentWindowsID);
		driver.findElement(fbFooterX).click();
		switchToWindowByTitle("HDFC Bank - Trang chủ | Facebook");

		System.out.println("TC03 : 5. Close All Windows Except Parent WWindows and Verify :");
		closeAllWindowsExceptParentWindows(parentWindowsID);
		verifyWindowsTitle("HDFC Bank:  Personal Banking Services");

	}

	@Test
	public void TC04_Handle_WWindows() throws Exception {

		String pageUrl = "http://live.guru99.com/index.php/";
		driver.get(pageUrl);
		String parentWindowsID = driver.getWindowHandle();

		System.out.println("TC04 : 1. Click Mobile Tab");
		driver.findElement(mobileTabX).click();

		System.out.println("TC04 : 2. Add Sony Xperia to Compare List ");
		driver.findElement(sonyCompareX).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(successMsgX).getText());

		System.out.println("TC04 : 3. Add Samsung Galaxy to Compare List ");
		driver.findElement(samsungCompareX).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(successMsgX).getText());

		System.out.println("TC04 : 4. Switch to Compare Link and Verify ");
		driver.findElement(compareBtnX).click();
		switchToWindowByTitle("Products Comparison List - Magento Commerce");
		verifyWindowsTitle("Products Comparison List - Magento Commerce");

		System.out.println("TC04 : 5. Close All Windows Except Parent WWindows and Verify :");
		closeAllWindowsExceptParentWindows(parentWindowsID);
	}

	public void switchToWindowsByID(String parentID) {

		Set<String> allWindowsID = driver.getWindowHandles();

		for (String currentWWindowID : allWindowsID) {
			if (parentID.equals(currentWWindowID)) {
				driver.switchTo().window(currentWWindowID);
				break;
			}

		}

	}

	public void switchToWindowByTitle(String targerTitle) {

		Set<String> allWindowsID = driver.getWindowHandles();

		for (String currentWWindowID : allWindowsID) {
			driver.switchTo().window(currentWWindowID);
			String currentTitle = driver.getTitle();
			if (targerTitle.equals(currentTitle)) {
				break;
			}
		}

	}

	public void verifyWindowsTitle(String expResult) {
		String actResult = driver.getTitle();
		if (actResult.equals(expResult)) {
			System.out.println(" [" + actResult + "] Title is Verified Succesfully !!!");
		} else {
			System.out.println(" Failed to Verify [" + actResult + "] Title !!!");
		}
	}

	public void closeAllWindowsExceptParentWindows(String parentWindowsID) {

		Set<String> allWindowsID = driver.getWindowHandles();

		for (String currentWWindowID : allWindowsID) {

			if (!parentWindowsID.equals(currentWWindowID)) {
				driver.switchTo().window(currentWWindowID);
				driver.close();
			}
		}

		driver.switchTo().window(parentWindowsID);
		if (driver.getWindowHandles().size() == 1) {
			System.out.println(" Close All Windows Except Parent Windows Successfully !!!");
		} else {
			System.out.println(" Failed to Close All Windows Except Parent WWindows");
		}

	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
