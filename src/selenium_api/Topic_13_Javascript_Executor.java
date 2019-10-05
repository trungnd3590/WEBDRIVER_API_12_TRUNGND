package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Javascript_Executor {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String cusName, dateOfbirth, address, city, state, pin, mobiNumber, email, password;

	By mobileTabX = By.xpath("//a[text()='Mobile']");
	By samsungAddToCartX = By.xpath(
			"//a[@title='Samsung Galaxy']/parent::h2//following-sibling::div[@class='actions']//button[@class='button btn-cart']");
	String successMsgX = "//li[@class='success-msg']//span";
	By customerPageX = By.xpath("//a[text()='Customer Service']");
	By newLetterTxtX = By.xpath("//input[@id='newsletter']");

	By userIdX = By.xpath("//input[@name='uid']");
	By passIdX = By.xpath("//input[@name='password']");
	By logInBtnX = By.xpath("//input[@name='btnLogin']");
	By newCusTabX = By.xpath("//a[text()='New Customer']");
	By cusNameTxt = By.xpath("//input[@name='name']");
	By dopTxt = By.xpath("//input[@name='dob']");
	By addrTat = By.xpath("//textarea[@onblur='validateAddress();']");
	By cityTxt = By.xpath("//input[@onblur='validateCity();']");
	By stateTxt = By.xpath("//input[@onblur='validateState();']");
	By pinTxt = By.xpath("//input[@onblur='validatePIN();']");
	By mobiNumTxt = By.xpath("//input[@onblur='validateTelephone();']");
	By emailTxt = By.xpath("//input[@onblur='validateEmail();']");
	By passTxt = By.xpath("//input[@name='password']");
	By submitBtnX = By.xpath("//input[@name='sub']");
	By verifyTxtX = By.xpath("//p[@class='heading3']");

	By myAccX = By.xpath("//div[@class='footer']//a[@title='My Account']");
	By registerBtnX = By.xpath("//a[contains(@title,'Create')]");
	By firstNameFieldX = By.xpath("//input[@id='firstname']");
	By lastNameFieldX = By.xpath("//input[@id='lastname']");
	By emailAdrFieldX = By.xpath("//input[@id='email_address']");
	By passResFieldX = By.xpath("//input[@id='password']");
	By conPasResFieldX = By.xpath("//input[@id='confirmation']");
	By registerSubX = By.xpath("//button[@title='Register']");
	By successRegMsgX = By.xpath("//li[@class='success-msg']");
	By accBtn = By.xpath("//span[@class='label' and text() = 'Account']");
	By logOutBtn = By.xpath("//a[@title='Log Out']");
	String lastNameVal = "testing" + randomNumber() + "";
	String passVal = "autotest" + randomNumber() + "";

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Chrome Driver ");

		/*
		 * String projectFolder = System.getProperty("user.dir");
		 * System.setProperty("webdrive.chrome.driver", projectFolder +
		 * "\\libraries\\chromedriver.exe"); driver = new ChromeDriver();
		 */
		driver = new FirefoxDriver();
		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		jsExecutor = (JavascriptExecutor) driver;

		cusName = "Kerrin Laird Craig";
		dateOfbirth = "2018-10-19";
		address = "50 Cambridge Plaza";
		city = "Columbus";
		state = "Ohio";
		pin = "441066";
		mobiNumber = "6141912444";
		email = "amacsporr@eativecommons.org";
		password = "nId5rmqZrR";
	}

	@Test
	public void TC01_Handle_Javascript_Executor() throws Exception {

		String pageUrl01 = "http://live.guru99.com/";
		String pageUrl02 = "http://demo.guru99.com/v4/";
		String scriptUrl01 = "window.location = \'" + pageUrl01 + "\'";
		String scriptUrl02 = "window.location = \'" + pageUrl02 + "\'";
		String expDomain01 = "live.guru99.com";
		String expDomain02 = "demo.guru99.com";
		String expUrl = "http://live.guru99.com/";
		String expSuccesMgs = "Samsung Galaxy was added to your shopping cart.";
		String expCustomerPageTitle = "Customer Service";
		String contentTextMgs = "Praesent ipsum libero, auctor ac, tempus nec, tempor nec, justo.";

		System.out.println("TC01 : 1. Access to Target Page Using JE !!!");
		jsExecutor.executeScript(scriptUrl01);
		Thread.sleep(1000);

		System.out.println("TC01 : 2. Verify Page Domain : ");
		String actDomain01 = (String) jsExecutor.executeScript("return document.domain");
		if (actDomain01.equals(expDomain01)) {
			System.out.println(" Verify Page Domain Successfully !!!");
		} else {
			System.out.println(" Failed to Verify Page Domain !!!");
		}

		System.out.println("TC01 : 3. Verify Page URL : ");
		String actUrl = (String) jsExecutor.executeScript("return document.URL");
		if (actUrl.equals(expUrl)) {
			System.out.println(" Verify Page URL Successfully !!!");
		} else {
			System.out.println(" Failed to Verify Page URL !!!");
		}

		System.out.println("TC01 : 4. Click Mobile Tab ");
		WebElement mobileTab = driver.findElement(mobileTabX);
		jsExecutor.executeScript("arguments[0].click();", mobileTab);

		System.out.println("TC01 : 5. Add Samsung Galaxy to Shopping Cart ");
		WebElement addToCart = driver.findElement(samsungAddToCartX);
		jsExecutor.executeScript("arguments[0].click();", addToCart);

		System.out.println("TC01 : 6. Verify Success Message ");
		Thread.sleep(2000);
		if (verifyTextInInnerText(expSuccesMgs) == true) {
			System.out.println(" Verify Success Message Successfully !!!");
		} else {
			System.out.println("Failed to Verify Success Message !!!");
		}

		System.out.println("TC01 : 7. Click Customer Service Page and Verify");
		WebElement customerPage = driver.findElement(customerPageX);
		jsExecutor.executeScript("arguments[0].click();", customerPage);
		String actCustomerPageTitle = (String) jsExecutor.executeScript("return document.title");
		if (actCustomerPageTitle.equals(expCustomerPageTitle)) {
			System.out.println(" Verify Privacy Page Title Successfully !!!");
		} else {
			System.out.println(" Failed to Verify rivacy Page Title !!!");
		}

		System.out.println("TC01 : 8. Scroll to New Letter TextBox ");
		WebElement newLetterTxt = driver.findElement(newLetterTxtX);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", newLetterTxt);

		System.out.println("TC01 : 9. Verify Content Text Message");
		if (verifyTextInInnerText(contentTextMgs) == true) {
			System.out.println(" Verify Content Text Message Successfully !!!");
		} else {
			System.out.println("Failed to Verify Content Text Message !!!");
		}

		System.out.println("TC01 : 10 : Navigate to another Page ");
		jsExecutor.executeScript(scriptUrl02);
		Thread.sleep(1000);

		System.out.println("TC01 : 11. Verify Page Domain : ");
		String actDomain02 = (String) jsExecutor.executeScript("return document.domain");
		if (actDomain02.equals(expDomain02)) {
			System.out.println(" Verify Page Domain Successfully !!!");
		} else {
			System.out.println(" Failed to Verify Page Domain !!!");
		}

	}

	@Test
	public void TC02_Remove_Attribute_JE() throws Exception {

		String pageUrl = "http://demo.guru99.com/v4/";
		String scriptUrl = "window.location = \'" + pageUrl + "\'";
		String userID = "mngr226268";
		String passID = "upEzedA";

		System.out.println("TC02 : 1. Access to Page :" + pageUrl);
		jsExecutor.executeScript(scriptUrl);
		Thread.sleep(1000);

		System.out.println("TC02 : 2. Login to Page ");
		sendkeyToElementByJS(userIdX, userID);
		sendkeyToElementByJS(passIdX, passID);
		clickToElementByJS(logInBtnX);
		Thread.sleep(1000);

		System.out.println("TC02 : 3. Click to New Customer Tab");
		clickToElementByJS(newCusTabX);
		Thread.sleep(1000);

		System.out.println("TC02 : 4. Add New Customer Data");

		sendkeyToElementByJS(cusNameTxt, cusName);
		Thread.sleep(1000);
		removeAttributeInDOM(dopTxt, "type");
		Thread.sleep(1000);
		sendkeyToElementByJS(dopTxt, dateOfbirth);
		Thread.sleep(1000);

		sendkeyToElementByJS(addrTat, address);
		Thread.sleep(1500);

		sendkeyToElementByJS(cityTxt, city);
		Thread.sleep(1000);
		sendkeyToElementByJS(stateTxt, state);
		Thread.sleep(1000);
		sendkeyToElementByJS(pinTxt, pin);
		Thread.sleep(1000);
		sendkeyToElementByJS(mobiNumTxt, mobiNumber);
		Thread.sleep(1000);
		sendkeyToElementByJS(emailTxt, email);
		Thread.sleep(1000);
		sendkeyToElementByJS(passTxt, password);
		Thread.sleep(1000);
		clickToElementByJS(submitBtnX);
		Thread.sleep(1000);

		System.out.println("TC02 : 5. Get Success Message : " + driver.findElement(verifyTxtX).getText());

	}

	@Test
	public void TC03_Create_An_Account_JE() throws Exception {

		String pageUrl = "http://live.guru99.com/";
		String scriptUrl = "window.location = \'" + pageUrl + "\'";
		String passResVal = "autotest" + randomNumber() + "";

		System.out.println("TC03 : 1. Access to Page :" + pageUrl);
		jsExecutor.executeScript(scriptUrl);
		Thread.sleep(1000);

		System.out.println("TC03 : 2. Click My Account Link");
		clickToElementByJS(myAccX);
		Thread.sleep(1000);

		System.out.println("TC03 : 3. Click CREATE AN ACCOUNT button");
		clickToElementByJS(registerBtnX);
		Thread.sleep(1000);

		System.out.println("TC03 : 4. Add new Account");
		sendkeyToElementByJS(firstNameFieldX, "automation");
		sendkeyToElementByJS(lastNameFieldX, "testing" + randomNumber() + "");
		sendkeyToElementByJS(emailAdrFieldX, "automationtesting" + randomNumber() + "@gmail.com");
		sendkeyToElementByJS(passResFieldX, passResVal);
		sendkeyToElementByJS(conPasResFieldX, passResVal);

		System.out.println("TC03 : 5. Click Register Button");
		clickToElementByJS(registerSubX);
		Thread.sleep(1000);

		System.out.println("TC03 : 6. Verify Regiter Success Message");
		verifyTextInInnerText("Thank you for registering with Main Website Store.");
		Thread.sleep(1000);

		System.out.println("TC03 : 7. Click Log Out Button");
		clickToElementByJS(logOutBtn);
		Thread.sleep(6000);

		System.out.println(
				"TC03 : 8. Verify navigate to HomePage :" + (String) jsExecutor.executeScript("return document.URL"));

	}

	public void removeAttributeInDOM(By by, String attributeRemove) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(by);
		js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public void clickToElementByJS(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(by);
		js.executeScript("arguments[0].click();", element);
	}

	public void sendkeyToElementByJS(By by, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(by);
		js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public boolean verifyTextInInnerText(String textExpected) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String textActual = (String) js
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual = " + textActual);
		return textActual.equals(textExpected);
	}

	public int randomNumber() {

		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
