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

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon Step 01 : Init Firefox Driver ");

		driver = new FirefoxDriver();

		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Pre-condition - Step 03: Open guru99 url");
		driver.get("https://live.guru99.com/");
		System.out.println();

	}

	@Test
	public void TC01_Login_Empty() throws Exception {

		String UserExpValMes = "This is a required field.";
		String PassExpValMes = "This is a required field.";

		System.out.println("Run TC_01 : Login Empty");
		System.out.println();

		System.out.println("Run TC_01 : 1. Click on My Account link to Login Page");
		driver.findElement(By.xpath(".//*[@class='footer']//a[@title='My Account']")).click();
		Thread.sleep(3000);

		System.out.println("Run TC_01 : 2. Leave Blank Username and Password and click Login Button");
		driver.findElement(By.xpath(".//*[@id='send2']")).click();
		Thread.sleep(3000);

		System.out.println("Run TC_01 : 3. Get Username and Password Validate message");
		String UserActValMes = driver.findElement(By.xpath(".//*[@id='advice-required-entry-email']")).getText();
		String PasVActValMes = driver.findElement(By.xpath(".//*[@id='advice-required-entry-pass']")).getText();

		System.out.println("Run TC_01 : 4. Verify Expected Validate message match with Actual Validate message ");
		Assert.assertEquals(UserActValMes, UserExpValMes);
		Assert.assertEquals(PasVActValMes, PassExpValMes);

	}

	@Test
	public void TC02_Login_With_Email_Invalid() throws Exception {

		String UserExpValMes = "Please enter a valid email address. For example johndoe@domain.com.";

		System.out.println();
		System.out.println("Run TC_02 : Login With Email Invalid");
		System.out.println();

		System.out.println("Run TC_02 : 1. Enter Invalid Email");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("asasdasdasdas@adssadasdas");
		Thread.sleep(3000);

		System.out.println("Run TC_02 : 2. Click Login Button");
		driver.findElement(By.xpath(".//*[@id='send2']")).click();
		Thread.sleep(3000);

		System.out.println("Run TC_02 : 3. Get Username Validate Message");
		String UserActValMes = driver.findElement(By.xpath(".//*[@id='advice-required-entry-email']")).getText();

		System.out.println("Run TC_02 : 4. Verify Expected Validate message match with Actual Validate message ");
		Assert.assertEquals(UserActValMes, UserExpValMes);

	}

	@Test
	public void TC03_Login_With_Password_Smaller_Than_6_Character() throws Exception {
		// TODO Auto-generated method stub

		String PassExpValMes = "Please enter 6 or more characters without leading or trailing spaces.";

		System.out.println();
		System.out.println("Pre-Condition TC_03 : Clear Username Validate Message");
		driver.findElement(By.xpath(".//*[@id='email']")).clear();

		System.out.println("Run TC_03 : Login With Password Smaller Than 6 Character");
		System.out.println();

		System.out.println("Run TC_03 : 1. Enter Valid Email");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("automation@gmail.com");
		Thread.sleep(3000);

		System.out.println();
		System.out.println("Run TC_03 : 2. Enter invalid Password");
		System.out.println();
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("123");
		Thread.sleep(3000);

		System.out.println("Run TC_03 : 3. Get Password Validate Message");
		String PassActValMes = driver.findElement(By.xpath(".//*[@id='advice-required-entry-pass']")).getText();

		System.out.println("Run TC_03 : 4. Verify Expected Validate message match with Actual Validate message ");
		Assert.assertEquals(PassActValMes, PassExpValMes);
	}

	@Test
	public void TC04_Login_With_Password_Incorrect() throws Exception {
		// TODO Auto-generated method stub

		String ExpValMes = "Invalid login or password.";

		System.out.println();
		System.out.println("Pre-Condition TC_04 : 1. Clear Username Field");
		driver.findElement(By.xpath(".//*[@id='email']")).clear();

		System.out.println("Pre-Condition TC_04 : 2. Clear Password Field");
		driver.findElement(By.xpath(".//*[@id='pass']")).clear();

		System.out.println();
		System.out.println("Run TC_04 : Login With Password Incorrect");
		System.out.println();

		System.out.println("Run TC_04 : 1. Enter Valid Email");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("automation@gmail.com");
		Thread.sleep(3000);

		System.out.println("Run TC_04 : 2. Enter invalid Password");
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("123123123123");
		Thread.sleep(3000);

		System.out.println("Run TC_04 : 3. Get Password Validate Message");
		String ActValMes = driver.findElement(By.xpath(".//*[@class='error-msg']//span")).getText();

		System.out.println("Run TC_04 : 4. Verify Expected Validate message match with Actual Validate message ");
		Assert.assertEquals(ActValMes, ExpValMes);
	}

	@Test
	public void TC05_Create_An_Account() throws Exception {
		// TODO Auto-generated method stub

		String ExpValMess = "Thank you for registering with Main Website Store.";
		String ExpUrl = "http://live.guru99.com/index.php/";
		String ExpTitle = "Home page";

		System.out.println();
		System.out.println("Run TC_05 : Create An Account");
		System.out.println();

		System.out.println("Run TC_05 : 1. Click Register Button");
		driver.findElement(By.xpath(".//*[@title='Create an Account']")).click();
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 2. Enter Valid First Name Field");
		driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys("automation");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 3. Enter Valid Last Name Field");
		driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys("testing01");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 4. Enter Valid Email Address Field");
		driver.findElement(By.xpath(".//*[@id='email_address']")).sendKeys("automationtesting01@gmail.com");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 5. Enter Valid Password Field");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("autotest01");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 6. Enter Valid Confirm Password Field");
		driver.findElement(By.xpath(".//*[@id='confirmation']")).sendKeys("autotest01");
		Thread.sleep(3000);

		System.out.println("Run TC_05 : 7. Click Register Button");
		driver.findElement(By.xpath(".//*[@class='button']")).click();
		Thread.sleep(3000);

		System.out.println("Run TC_05 : Get Success Message");
		String ActValMess = driver.findElement(By.xpath(".//*[@class='success-msg']//span")).getText();
		Thread.sleep(3000);

		Assert.assertEquals(ActValMess, ExpValMess);
		Thread.sleep(3000);

		System.out.println("Run TC_05 : Open Account Dropdownlist");
		driver.findElement(By.xpath(".//*[@class='skip-link skip-account skip-active']//span[@class='label']")).click();
		Thread.sleep(3000);

		System.out.println("Run TC_05 : Click Log Out Button");
		driver.findElement(By.xpath(".//*//a[@title='Log Out']")).click();
		Thread.sleep(3000);

		System.out.println("Run TC_05 : Get Url and Title Page");
		String ActUrl = driver.getCurrentUrl();
		String ActTitle = driver.getTitle();

		System.out.println("Run TC_05 : Verify Expected Homepage match with Actual Validate Homepage");
		Assert.assertEquals(ActTitle, ExpTitle);
		Assert.assertEquals(ActUrl, ExpUrl);

	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
