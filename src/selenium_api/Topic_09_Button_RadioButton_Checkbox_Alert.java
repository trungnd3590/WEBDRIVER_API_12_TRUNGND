package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_09_Button_RadioButton_Checkbox_Alert {

	WebDriver driver;
	JavascriptExecutor js;

	By myAccX = By.xpath("//div[@class='footer']//a[@title='My Account']");
	By registerAccX = By.xpath("//span[text()='Create an Account']");

	By cusCheckboxX = By.xpath("//input[@id='eq5']");

	By cusRadioX = By.xpath("//input[@id='engine3']");

	By jsAlertX = By.xpath("//button[@onclick='jsAlert()']");
	By jsConfirmX = By.xpath(".//button[@onclick='jsConfirm()']");
	By jsPromptX = By.xpath(".//button[@onclick='jsPrompt()']");
	By resultX = By.xpath("//p[@id='result']");

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");

		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;

		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_Handle_ButtonJavaExecutor() throws Exception {

		String pageUrl = "http://live.guru99.com/";
		String expMyAcc = "http://live.guru99.com/index.php/customer/account/login/";
		String expRegAcc = "http://live.guru99.com/index.php/customer/account/create/";

		driver.get(pageUrl);
		WebElement myAcc = driver.findElement(myAccX);
		js.executeScript("arguments[0].click();", myAcc);
		Thread.sleep(2000);
		if (driver.getCurrentUrl().equals(expMyAcc)) {
			System.out.println("1. My Account Url Matched");
		} else {
			System.out.println("1. My Account Url NOT Matched");
		}

		WebElement registerAcc = driver.findElement(registerAccX);
		js.executeScript("arguments[0].click();", registerAcc);
		Thread.sleep(2000);
		if (driver.getCurrentUrl().equals(expRegAcc)) {
			System.out.println("2. Create Account Url Matched");
		} else {
			System.out.println("2. Create Account Url NOT Matched");
		}
	}

	@Test
	public void TC02_Handle_CustomCheckbox() throws Exception {

		String pageUrl = "http://demos.telerik.com/kendo-ui/styling/checkboxes";
		driver.get(pageUrl);

		WebElement cusCheckbox = driver.findElement(cusCheckboxX);
		js.executeScript("arguments[0].click();", cusCheckbox);
		Thread.sleep(2000);
		if (cusCheckbox.isSelected() == true) {
			System.out.println("1. Dual-zone air conditioning Checkbox is Checked");
		} else {
			System.out.println("1. Dual-zone air conditioning Checkbox is UN-Checked");
		}

		js.executeScript("arguments[0].click();", cusCheckbox);
		Thread.sleep(2000);
		if (cusCheckbox.isSelected() == true) {
			System.out.println("2. Dual-zone air conditioning Checkbox is Checked");
		} else {
			System.out.println("2. Dual-zone air conditioning Checkbox is UN-Checked");
		}
	}

	@Test
	public void TC03_Handle_RadioButton() throws Exception {

		String pageUrl = "http://demos.telerik.com/kendo-ui/styling/radios";
		driver.get(pageUrl);

		WebElement cusRadio = driver.findElement(cusRadioX);
		js.executeScript("arguments[0].click();", cusRadio);
		Thread.sleep(2000);
		if (cusRadio.isSelected() == true) {
			System.out.println("2.0 Petrol, 147kW Radio Button is Checked");
		} else {
			System.out.println("2.0 Petrol, 147kW Radio Button is UN-Checked");
		}

	}

	@Test
	public void TC040506_Handle_Alert() throws Exception {

		String pageUrl = "https://daominhdam.github.io/basic-form/index.html";
		driver.get(pageUrl);

		driver.findElement(jsAlertX).click();
		Alert jsAlert = driver.switchTo().alert();
		Assert.assertEquals(jsAlert.getText(), "I am a JS Alert");
		jsAlert.accept();
		Assert.assertEquals(driver.findElement(resultX).getText(), "You clicked an alert successfully");

		Thread.sleep(2000);

		driver.findElement(jsConfirmX).click();
		Alert jsConfirm = driver.switchTo().alert();
		Assert.assertEquals(jsConfirm.getText(), "I am a JS Confirm");
		jsConfirm.dismiss();
		Assert.assertEquals(driver.findElement(resultX).getText(), "You clicked: Cancel");

		Thread.sleep(2000);

		driver.findElement(jsPromptX).click();
		Alert jsPrompt = driver.switchTo().alert();
		Assert.assertEquals(jsConfirm.getText(), "I am a JS prompt");
		jsPrompt.sendKeys("daominhdan");
		jsPrompt.accept();
		Assert.assertEquals(driver.findElement(resultX).getText(), "You entered: daominhdan");
	}

	@Test
	public void TC07_Handle_AuthenAlert() {

		String user = "admin";
		String pass = "admin";
		String pageUrl = "the-internet.herokuapp.com/basic_auth";

		driver.get("http://" + user + ":" + pass + "@" + pageUrl);
	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
