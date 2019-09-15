package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_07_08_Textbox_TextArea_Dropdown_Custom_Dropdown {
	WebDriver driver;

	String userVal = "mngr209708";
	String passVal = "arasYsY";
	String cusName, dateOfbirth, address, city, state, pin, mobiNumber, email, password;
	String editAddress, editCity, editState, editPin, editMobiNumber, editEmail;

	By userId = By.xpath("//input[@name='uid']");
	By passId = By.xpath("//input[@name='password']");
	By btnLogin = By.xpath("//input[@name='btnLogin']");
	By homePageVal = By.xpath("//marquee[@class='heading3']");
	By newCusPage = By.xpath("//a[@href='addcustomerpage.php']");
	By cusNameTxt = By.xpath("//input[@name='name']");
	By genderRad = By.xpath("//input[@name='gender']");
	By dopTxt = By.xpath("//input[@name='dob']");
	By addrTat = By.xpath("//textarea[@onblur='validateAddress();']");
	By cityTxt = By.xpath("//input[@onblur='validateCity();']");
	By stateTxt = By.xpath("//input[@onblur='validateState();']");
	By pinTxt = By.xpath("//input[@onblur='validatePIN();']");
	By mobiNumTxt = By.xpath("//input[@onblur='validateTelephone();']");
	By emailTxt = By.xpath("//input[@onblur='validateEmail();']");
	By passTxt = By.xpath("//input[@name='password']");
	By newSubmitBtn = By.xpath("//input[@type='submit']");
	By cusNameId = By.xpath("//td[text()='Customer ID']");
	By cusNameIdVal = By.xpath("//td[text()='Customer ID']/following-sibling::td");
	By cusNameVal = By.xpath("//td[text()='Customer Name']/following-sibling::td");
	By genderVal = By.xpath("//td[text()='Gender']/following-sibling::td");
	By dobVal = By.xpath("//td[text()='Birthdate']/following-sibling::td");
	By addVal = By.xpath("//td[text()='Address']/following-sibling::td");
	By cityVal = By.xpath("//td[text()='City']/following-sibling::td");
	By stateVal = By.xpath("//td[text()='State']/following-sibling::td");
	By pinval = By.xpath("//td[text()='Pin']/following-sibling::td");
	By mobiNumVal = By.xpath("//td[text()='Mobile No.']/following-sibling::td");
	By emailVal = By.xpath("//td[text()='Email']/following-sibling::td");
	By editCusPage = By.xpath("//a[@href='EditCustomer.php']");
	By editCusIdTxt = By.xpath("//input[@name='cusid']");
	By editSubmitBtn = By.xpath("//input[@name='AccSubmit']");

	By job01DDL = By.xpath("//select[@id='job1']");

	By jqueryPage01 = By.xpath("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]");
	By agularPage = By.xpath("//mat-select[@id='mat-select-5']//span[contains(@class,'ng-tns-c21-18')]");
	By reactPage = By.xpath("//div[text()='Select Friend']");
	By vuePage = By.xpath("//li[@class='dropdown-toggle']");
	By editPage = By.xpath("//div[@id='default-place']");

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");

		driver = new FirefoxDriver();

		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		cusName = "Kerrin Laird Craig";
		dateOfbirth = "2018-10-19";
		address = "50 Cambridge Plaza";
		city = "Columbus";
		state = "Ohio";
		pin = "441066";
		mobiNumber = "6141912444";
		email = "amacsporr@eativecommons.org";
		password = "nId5rmqZrR";

		editAddress = "1 Mccormick Hill";
		editCity = "Beaufort";
		editState = "South Carolina";
		editPin = "345345";
		editMobiNumber = "8434743827";
		editEmail = "rbroadhead2@desdev.cn";
	}

	@Test

	public void TC01_Handle_Textbox_Textarea() throws Exception {
		String expHomePageVal = "Welcome To Manager's Page of Guru99 Bank";
		String cusID;
		String gender = "male";
		String pageUrl = "http://demo.guru99.com/v4/";

		System.out.println("Pre-condition : Open Page url");
		driver.get(pageUrl);

		// Đăng nhập tài khoản
		sendkeyElement(userId, userVal);
		sendkeyElement(passId, passVal);
		clickToElement(btnLogin);

		// Check đăng nhập thành công
		Thread.sleep(3000);
		Assert.assertEquals(getTextElement(homePageVal), expHomePageVal);
		System.out.println("Step 01 : Home Page Value :" + getTextElement(homePageVal));

		// Chọn menu New Cusomer clickToElement(newCusPage); Thread.sleep(2000);

		// Nhập thông tin Customer và submit
		sendkeyElement(cusNameTxt, cusName);
		sendkeyElement(dopTxt, dateOfbirth);
		sendkeyElement(addrTat, address);
		sendkeyElement(cityTxt, city);
		sendkeyElement(stateTxt, state);
		sendkeyElement(pinTxt, pin);
		sendkeyElement(mobiNumTxt, mobiNumber);
		sendkeyElement(emailTxt, email);
		sendkeyElement(passTxt, password);
		clickToElement(newSubmitBtn);
		Thread.sleep(2000);
		System.out.println("Step 02 : Add value to New Customer form Successfully !!");

		// Lấy thông tin Cusomer và so sánh với input
		cusID = getTextElement(cusNameIdVal);
		Assert.assertEquals(getTextElement(cusNameVal), cusName);
		Assert.assertEquals(getTextElement(genderVal), gender);
		Assert.assertEquals(getTextElement(dobVal), dateOfbirth);
		Assert.assertEquals(getTextElement(addVal), address);
		Assert.assertEquals(getTextElement(cityVal), city);
		Assert.assertEquals(getTextElement(stateVal), state);
		Assert.assertEquals(getTextElement(pinval), pin);
		Assert.assertEquals(getTextElement(mobiNumVal), mobiNumber);
		Assert.assertEquals(getTextElement(emailVal), email);
		System.out.println("Step 03 : Compare New Customer Input Anh Output Value Successfully");

		// Chọn menu Edit Customer
		clickToElement(editCusPage);
		Thread.sleep(2000);
		sendkeyElement(editCusIdTxt, cusID);
		clickToElement(editSubmitBtn);
		Thread.sleep(2000);
		System.out.println("Step 04 : Navigate to Edit Customer form Successfully !!");

		// So sánh thông tin edit hiển thị với input
		Assert.assertEquals(getAttributeElement(cusNameTxt), cusName);
		Assert.assertEquals(getAttributeElement(genderRad), gender);
		Assert.assertEquals(getAttributeElement(dopTxt), dateOfbirth);
		Assert.assertEquals(getAttributeElement(addrTat), address);
		Assert.assertEquals(getAttributeElement(cityTxt), city);
		Assert.assertEquals(getAttributeElement(stateTxt), state);
		Assert.assertEquals(getAttributeElement(pinTxt), pin);
		Assert.assertEquals(getAttributeElement(mobiNumTxt), mobiNumber);
		Assert.assertEquals(getAttributeElement(emailTxt), email);
		System.out.println("Step 05 : Compare Customer Input Anh Edit Output Value Successfully");

		// Nhập thông tin Customer mới
		sendkeyElement(addrTat, editAddress);
		sendkeyElement(cityTxt, editCity);
		sendkeyElement(stateTxt, editState);
		sendkeyElement(pinTxt, editPin);
		sendkeyElement(mobiNumTxt, editMobiNumber);
		sendkeyElement(emailTxt, editEmail);
		clickToElement(newSubmitBtn);
		Thread.sleep(2000);
		System.out.println("Step 06 : Edit Custoemr Successfully !!");

		// So sánh thông tin mới với input

		Assert.assertEquals(getTextElement(cusNameVal), cusName);
		Assert.assertEquals(getTextElement(genderVal), gender);
		Assert.assertEquals(getTextElement(dobVal), dateOfbirth);
		Assert.assertEquals(getTextElement(addVal), editAddress);
		Assert.assertEquals(getTextElement(cityVal), editCity);
		Assert.assertEquals(getTextElement(stateVal), editState);
		Assert.assertEquals(getTextElement(pinval), editPin);
		Assert.assertEquals(getTextElement(mobiNumVal), editMobiNumber);
		Assert.assertEquals(getTextElement(emailVal), editEmail);
		System.out.println("Step 07 : Compare Customer Edit Input Anh Edit Output Value Successfully");
	}

	@Test

	public void TC02_Handle_HTML_Dropdownlist() throws Exception {

		String pageUrl = "https://daominhdam.github.io/basic-form/index.html";
		String autoValue = "Automation Tester";
		String manualValue = "manual";
		WebElement jo01;
		String j01;

		System.out.println("Pre-condition : Open Page url");
		driver.get(pageUrl);
		Thread.sleep(2000);

		// Kiểm tra Job 01 có hỗ trợ mutliselect không
		Select job01 = new Select(driver.findElement(job01DDL));
		if (job01.isMultiple() == true) {
			System.out.println("Step 01 : Job Role 01 Dropdownlist is multi-select");
		} else {
			System.out.println("Step 01 : Job Role 01 Dropdownlist is NOT multi-select");
		}

		// Chọn giá trị trong Dropdownlist bằng selectByVisibleText
		job01.selectByVisibleText(autoValue);
		jo01 = job01.getFirstSelectedOption();
		j01 = jo01.getText();
		System.out.println("Step 02 : Job Role 01 Dropdownlist value is : " + j01);

		// Chọn giá trị trong Dropdownlist bằng selectByValue
		job01.selectByValue(manualValue);
		jo01 = job01.getFirstSelectedOption();
		j01 = jo01.getText();
		System.out.println("Step 03 : Job Role 01 Dropdownlist value is : " + j01);

		// Chọn giá trị trong Dropdownlist bằng selectIndex
		job01.selectByIndex(3);
		jo01 = job01.getFirstSelectedOption();
		j01 = jo01.getText();
		System.out.println("Step 04 : Job Role 01 Dropdownlist value is : " + j01);

		// Đếm số lượng giá trị có trong Dropdownlist
		List<WebElement> jo01All = job01.getOptions();
		Assert.assertEquals(jo01All.size(), 5);
		System.out.println("Step 05 : Total Job Role 01 Dropdownlist : " + jo01All.size() + " values");

	}

	@Test
	public void TC03_Handle_Custom_Dropdownlist() throws Exception {

		String jqueryPageUrl = "https://jqueryui.com/resources/demos/selectmenu/default.html";
		String agularpageUrl = "https://material.angular.io/components/select/examples";
		String reactJSPageUrl = "https://react.semantic-ui.com/modules/dropdown/";
		String vuePageUrl = "https://mikerodham.github.io/vue-dropdowns/";
		// String editPageUrl = "http://indrimuska.github.io/jquery-editable-select/";

		// System.out.println(handleDropAndGetElement(jqueryPage, "19", jqueryPageUrl,
		// "Jquery Page"));

		/*
		 * System.out.println(handleDropAndGetElement(agularPage, "Arkansas",
		 * agularpageUrl, "Agular Page"));
		 * 
		 * System.out.println(handleDropAndGetElement(reactPage, "Stevie Feliciano",
		 * reactJSPageUrl, "Reacr JS Page"));
		 * 
		 * System.out.println(handleDropAndGetElement(vuePage, "Second Option",
		 * vuePageUrl, "Vue JS Page"));
		 */
		System.out.println("Pre-condition : Open Page url");
		driver.get(jqueryPageUrl);
		Thread.sleep(2000);
		driver.findElement(jqueryPage01).click();

	}

	public void sendkeyElement(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}

	public void clickToElement(By by) {
		driver.findElement(by).click();
	}

	public String getTextElement(By by) {
		return driver.findElement(by).getText();
	}

	public String getAttributeElement(By by) {
		return driver.findElement(by).getAttribute("value");
	}

	/*
	 * public String handleDropAndGetElement(By by, String dataValue, String
	 * pageUrl, String pageValue) throws Exception {
	 * 
	 * WebElement element ; String option;
	 * 
	 * System.out.println("Pre-condition : Open" + pageValue + " url");
	 * driver.get(pageUrl); Thread.sleep(2000);
	 * 
	 * // Tìm và chọn giá trị trong Dropdownlist reactJS Select pageElement = new
	 * Select(driver.findElement(by)); pageElement.selectByVisibleText(dataValue);
	 * element = pageElement.getFirstSelectedOption(); option = element.getText();
	 * String result = "Select a " + pageValue + " Dropdownlist value is : " +
	 * option;
	 * 
	 * return result; }
	 */

	@AfterClass
	public void afterClass() {

		System.out.println();
		System.out.println("Post-condition: Close Firefox browser");
		System.out.println();
		driver.quit();
	}

}
