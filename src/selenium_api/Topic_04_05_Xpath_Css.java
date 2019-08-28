package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_05_Xpath_Css {
	
	WebDriver driver;
	
	String guru99Url = "https://live.guru99.com/";
	String myAccXpath = "//div[@class='footer']//a[@title='My Account']";
	String loginBtn = "//button[@id='send2']";
	String emailField = "//input[@id='email']";
	String emailErrMes = "//div[contains(@id,'entry-email')]";
	String emailValMess = "//div[contains(@id,'validate-email')]";
	String passField = "//input[@id='pass']"; 
	String passErrMes = "//div[contains(@id,'entry-pass')]";
	String passValMess = "//div[contains(@id,'validate-password')]";
	String errMess = "//li[@class='error-msg']";
	String registerBtn = "//a[contains(@title,'Create')]";
	String firstNameField = "//input[@id='firstname']";
	String lastNameField = "//input[@id='lastname']";
	String emailAdrField = "//input[@id='email_address']";
	String passResField = "//input[@id='password']";
	String conPasResField = "//input[@id='confirmation']";
	String resBtn = "//button[@title='Register']";
	String successMsg = "//li[@class='success-msg']";
	String accBtn = "//span[@class='label' and text() = 'Account']";
	String logOutBtn = "//a[@title='Log Out']";

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");

		driver = new FirefoxDriver();

		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Pre-condition - Step 03: Open guru99 url");
		driver.get(guru99Url);

	}

	@Test //Passed
	public void TC01_Login_Empty() throws Exception {

		String UserExpValMes = "This is a required field.";
		String PassExpValMes = "This is a required field.";

		System.out.println();
		System.out.println("Run TC_01 : Login Empty");
		System.out.println();

		System.out.println("Run TC_01 : 1. Click on My Account link to Login Page");
		driver.findElement(By.xpath(myAccXpath)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_01 : 2. Leave Blank Username and Password and click Login Button");
		driver.findElement(By.xpath(loginBtn)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_01 : 3. Get Username and Password Validate message");
		String UserActValMes = driver.findElement(By.xpath(emailErrMes)).getText();
		String PasVActValMes = driver.findElement(By.xpath(passErrMes)).getText();

		System.out.println("Run TC_01 : 4. Verify Expected Validate message match with Actual Validate message ");
		Assert.assertEquals(UserActValMes, UserExpValMes);
		Assert.assertEquals(PasVActValMes, PassExpValMes);

	}

	@Test
	public void TC02_Login_With_Email_Invalid() throws Exception {

		String UserExpValMes = "Please enter a valid email address. For example johndoe@domain.com.";
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println();
		System.out.println("Run TC_02 : Login With Email Invalid");
		System.out.println();
		
		System.out.println("Run TC_02 : 1. Click on My Account link to Login Page");
		driver.findElement(By.xpath(myAccXpath)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_02 : 2. Enter Invalid Email");
		driver.findElement(By.xpath(emailField)).sendKeys("asasdasdasdas@adssadasdas");
		Thread.sleep(3000);

		System.out.println("Run TC_02 : 3. Click Login Button");
		driver.findElement(By.xpath(loginBtn)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_02 : 4. Get Username Validate Message");
		String UserActValMes = driver.findElement(By.xpath(emailValMess)).getText();

		System.out.println("Run TC_02 : 5. Verify Expected Validate message match with Actual Validate message ");
		Assert.assertEquals(UserActValMes, UserExpValMes);

	}

	@Test
	public void TC03_Login_With_Password_Smaller_Than_6_Character() throws Exception {
		// TODO Auto-generated method stub

		String PassExpValMes = "Please enter 6 or more characters without leading or trailing spaces.";

		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println();
		System.out.println("Run TC_03 : Login With Password Smaller Than 6 Character");
		System.out.println();
		
		System.out.println("Run TC_03 : 1. Click on My Account link to Login Page");
		driver.findElement(By.xpath(myAccXpath)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_03 : 2. Enter Valid Email");
		driver.findElement(By.xpath(emailField)).sendKeys("automation@gmail.com");
		Thread.sleep(3000);
		
		System.out.println("Run TC_03 : 3. Enter invalid Password");
		driver.findElement(By.xpath(passField)).sendKeys("123");
		Thread.sleep(3000);
		
		System.out.println("Run TC_02 : 4. Click Login Button");
		driver.findElement(By.xpath(loginBtn)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_03 : 5. Get Password Validate Message");
		String PassActValMes = driver.findElement(By.xpath(passValMess)).getText();

		System.out.println("Run TC_03 : 6. Verify Expected Validate message match with Actual Validate message ");
		Assert.assertEquals(PassActValMes, PassExpValMes);
	}

	@Test //Passed
	public void TC04_Login_With_Password_Incorrect() throws Exception {
		// TODO Auto-generated method stub

		String ExpValMes = "Invalid login or password.";
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println();
		System.out.println("Run TC_04 : Login With Password Incorrect");
		System.out.println();
		
		System.out.println("Run TC_04 : 1. Click on My Account link to Login Page");
		driver.findElement(By.xpath(myAccXpath)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_04 : 2. Enter Valid Email");
		driver.findElement(By.xpath(emailField)).sendKeys("automation@gmail.com");
		Thread.sleep(3000);

		System.out.println("Run TC_04 : 3. Enter invalid Password");
		driver.findElement(By.xpath(passField)).sendKeys("123123123123");
		Thread.sleep(3000);
		
		System.out.println("Run TC_02 : 4. Click Login Button");
		driver.findElement(By.xpath(loginBtn)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_04 : 5. Get Password Validate Message");
		String ActValMes = driver.findElement(By.xpath(errMess)).getText();

		System.out.println("Run TC_04 : 6. Verify Expected Validate message match with Actual Validate message ");
		Assert.assertEquals(ActValMes, ExpValMes);
	}

	@Test // Passed
	public void TC05_Create_An_Account() throws Exception {
		// TODO Auto-generated method stub

		String ExpValMess = "Thank you for registering with Main Website Store.";
		String ExpUrl = "http://live.guru99.com/index.php/";
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println();
		System.out.println("Run TC_05 : Create An Account");
		System.out.println();
		
		System.out.println("Run TC_05 : 1. Click on My Account link to Login Page");
		driver.findElement(By.xpath(myAccXpath)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 2. Click Register Button");
		driver.findElement(By.xpath(registerBtn)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 3. Enter Valid First Name Field");
		driver.findElement(By.xpath(firstNameField)).sendKeys("automation");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 4. Enter Valid Last Name Field");
		driver.findElement(By.xpath(lastNameField)).sendKeys("testing08");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 5. Enter Valid Email Address Field");
		driver.findElement(By.xpath(emailAdrField)).sendKeys("automationtesting08@gmail.com");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 6. Enter Valid Password Field");
		driver.findElement(By.xpath(passResField)).sendKeys("autotest01");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 7. Enter Valid Confirm Password Field");
		driver.findElement(By.xpath(conPasResField)).sendKeys("autotest01");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 8. Click Register Button");
		driver.findElement(By.xpath(registerBtn)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 9. Get Success Message");
		String ActValMess = driver.findElement(By.xpath(successMsg)).getText();
		Thread.sleep(3000);

		Assert.assertEquals(ActValMess, ExpValMess);
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 10. Open Account Dropdownlist");
		driver.findElement(By.xpath(accBtn)).click();
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 11. Click Log Out Button");
		driver.findElement(By.xpath(logOutBtn)).click();
		Thread.sleep(10000);

		System.out.println("Run TC_05 : 12. Get Url and Title Page");
		String ActUrl = driver.getCurrentUrl();

		System.out.println("Run TC_05 : 13. Verify Expected Homepage match with Actual Validate Homepage");
		Assert.assertEquals(ActUrl, ExpUrl);

	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
