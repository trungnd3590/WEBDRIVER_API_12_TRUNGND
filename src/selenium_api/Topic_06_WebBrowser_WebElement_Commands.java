package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_06_WebBrowser_WebElement_Commands {

	WebDriver driver;

	String pageUrl = "https://daominhdam.github.io/basic-form/index.html";

	String emailFieldXpath = "//input[@id='mail']";
	String passFieldXpath = "//input[@id='password']";
	String ageUnder18RadioBtnXpath = "//input[@id='under_18']";
	String ageRbtnDisXpath = "//input[@id='radio-disabled']";
	String eduFieldXpath = "//textarea[@id='edu']";
	String bioAreaXpath = "//textarea[@id='bio']";
	String job01Xpath = "//select[@id='job1']";
	String job02Xpath = "//select[@id='job2']";
	String inteDevCheckboxXpath = "//input[@id='development']";
	String inteDisCheckboxXpath = "//input[@id='check-disbaled']";
	String slide01Xpath = "//input[@id='slider-1']";
	String slide02Xpath = "//input[@id='slider-2']";
	String autoTest = "Automation Testing";

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");

		driver = new FirefoxDriver();

		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Pre-condition - Step 03: Open Page url");
		driver.get(pageUrl);
	}

	@Test
	public void TC01_CheckElementisDisplayed() {

		System.out.println();
		System.out.println("Run TC 01 : Check Element is Displayed");
		System.out.println();

		System.out.println("Step 01 : Check Email Field is Displayed or not");
		Boolean emailDis = driver.findElement(By.xpath(emailFieldXpath)).isDisplayed();

		if (emailDis == true) {
			driver.findElement(By.xpath(emailFieldXpath)).sendKeys(autoTest);
			System.out.println("Step 02 : Email Field is Displayed and can input data : Passed");
		} else {
			System.out.println("Step 02 : Email Field is Not Displayed : Failed");
		}

		System.out.println("Step 03 : Check Age under 18 Radio Button is Displayed or not");
		Boolean ageUnder18Dis = driver.findElement(By.xpath(ageUnder18RadioBtnXpath)).isDisplayed();

		if (ageUnder18Dis == true) {
			driver.findElement(By.xpath(ageUnder18RadioBtnXpath)).click();
			System.out.println("Step 04 :  Age under 18 Radio Button is Displayed amd Clicked : Passed");
		} else {
			System.out.println("Step 04 : Age under 18 Radio Button is Not Displayed : Failed");
		}

		System.out.println("Step 05 : Check Education Field is Displayed or not");
		Boolean educationDis = driver.findElement(By.xpath(eduFieldXpath)).isDisplayed();

		if (educationDis == true) {
			driver.findElement(By.xpath(eduFieldXpath)).sendKeys(autoTest);
			System.out.println("Step 06 : Education Field is Displayed and can input data : Passed");
		} else {
			System.out.println("Step 06 : Education Field is Not Displayed : Failed");
		}

	}

	@Test
	public void TC02_CheckElementisEnableDisable() {

		System.out.println();
		System.out.println("Run TC 02 : Check Element is Enable or Disable");
		System.out.println();

		Boolean emailEnable = driver.findElement(By.xpath(emailFieldXpath)).isEnabled();
		if (emailEnable == true) {
			System.out.println("Email Field is Enabled");
		} else {
			System.out.println("Email Field is Disable");
		}

		Boolean ageUnder18Enable = driver.findElement(By.xpath(ageUnder18RadioBtnXpath)).isEnabled();
		if (ageUnder18Enable == true) {
			System.out.println("Age Under 18 Radio Button is Enabled");
		} else {
			System.out.println("Age Under 18 Radio Button is Disable");
		}

		Boolean educationEnable = driver.findElement(By.xpath(eduFieldXpath)).isEnabled();
		if (educationEnable == true) {
			System.out.println("Education Field is Enabled");
		} else {
			System.out.println("Education Field is Disable");
		}

		Boolean job01Enable = driver.findElement(By.xpath(job01Xpath)).isEnabled();
		if (job01Enable == true) {
			System.out.println("Job Role 01 Dropdownlist is Enabled");
		} else {
			System.out.println("Job Role 01 Dropdownlist is Disable");
		}

		Boolean interestEnable = driver.findElement(By.xpath(inteDevCheckboxXpath)).isEnabled();
		if (interestEnable == true) {
			System.out.println("Interest Development Checkbox is Enabled");
		} else {
			System.out.println("Interest Development Checkbox is Disable");
		}

		Boolean slide01Enable = driver.findElement(By.xpath(slide01Xpath)).isEnabled();
		if (slide01Enable == true) {
			System.out.println("Slider 01 is Enabled");
		} else {
			System.out.println("Slider 01 is Disable");
		}

		System.out.println();

		Boolean passDisable = driver.findElement(By.xpath(passFieldXpath)).isEnabled();
		if (passDisable == true) {
			System.out.println("Password Field is Enabled");
		} else {
			System.out.println("Password Field is Disable");
		}

		Boolean ageRbtnDisable = driver.findElement(By.xpath(ageRbtnDisXpath)).isEnabled();
		if (ageRbtnDisable == true) {
			System.out.println("Radio Button is Enabled");
		} else {
			System.out.println("Radio Button is Disable");
		}

		Boolean bioDisable = driver.findElement(By.xpath(bioAreaXpath)).isEnabled();
		if (bioDisable == true) {
			System.out.println("Biography Field is Enabled");
		} else {
			System.out.println("Biography Field is Disable");
		}

		Boolean job02Disable = driver.findElement(By.xpath(job02Xpath)).isEnabled();
		if (job02Disable == true) {
			System.out.println("Job Role 02 Dropdownlist is Enabled");
		} else {
			System.out.println("Job Role 02 Dropdownlist is Disable");
		}

		Boolean interDisable = driver.findElement(By.xpath(inteDisCheckboxXpath)).isEnabled();
		if (interDisable == true) {
			System.out.println("Interest Checkbox is Enabled");
		} else {
			System.out.println("Interest Checkbox is Disabled");
		}

		Boolean slide02Disable = driver.findElement(By.xpath(slide02Xpath)).isEnabled();
		if (slide02Disable == true) {
			System.out.println("Slider 02 is Enabled");
		} else {
			System.out.println("Slider 02 is Disable");
		}

	}

	@Test
	public void TC03_CheckElementisSelected() {

		System.out.println();
		System.out.println("Run TC 03 : Check Element is Selected");
		System.out.println();

		System.out.println("Step 01 : Click Age Under 18 Radio Button");
		driver.findElement(By.xpath(ageUnder18RadioBtnXpath)).click();

		System.out.println("Step 02 : Click Interest Development Check Box");
		driver.findElement(By.xpath(inteDevCheckboxXpath)).click();

		System.out.println("Step 03 : Check Element is Selected ");
		Boolean ageSeleted = driver.findElement(By.xpath(ageUnder18RadioBtnXpath)).isSelected();
		Boolean inteSelected = driver.findElement(By.xpath(inteDevCheckboxXpath)).isSelected();

		Assert.assertTrue(ageSeleted);
		Assert.assertTrue(inteSelected);

		System.out.println("Step 04 : Uncheck Interest Development Check Box");
		driver.findElement(By.xpath(inteDevCheckboxXpath)).click();

		System.out.println("Step 05 : Check Element is Únelected");

		ageSeleted = driver.findElement(By.xpath(ageUnder18RadioBtnXpath)).isSelected();
		inteSelected = driver.findElement(By.xpath(inteDevCheckboxXpath)).isSelected();

		if (ageSeleted == true) {
			System.out.println("Step 05.01 : Age Under 18 Radio Button is Selected");
		} else {
			System.out.println("Step 05.01 : Age Under 18 Radio Button is NOT Seleted");
		}

		if (inteSelected == true) {
			System.out.println("Step 05.02 : Interest Development Checkbox is Selected");
		} else {
			System.out.println("Step 05.02 : Interest Development Checkbox is NOT Seleted");
		}

	}

	@AfterClass
	public void afterClass() {

		System.out.println();
		System.out.println("Post-condition: Close Firefox browser");
		System.out.println();
		driver.quit();
	}

}
