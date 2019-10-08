package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_14_Upload_File {

	WebDriver driver;

	By inputFileX = By.xpath("//input[@type='file']");
	By tableImgsX = By.xpath("//form[@id='fileupload']//p[@class='name']");
	By tableImgsStartX = By.xpath("//form[@id='fileupload']//span[text()='Start']");
	By tableImgsUploadedX = By
			.xpath("//form[@id='fileupload']//tr[@class='template-download fade in']//p[@class='name']");

	String projectPath = System.getProperty("user.dir");

	String imgFile01 = "IMG01.png";
	String imgFile02 = "IMG02.jpg";
	String imgFile03 = "IMG03.jpg";

	String imgFile01Path = projectPath + "\\fileUpload\\" + imgFile01;
	String imgFile02Path = projectPath + "\\fileUpload\\" + imgFile02;
	String imgFile03Path = projectPath + "\\fileUpload\\" + imgFile03;

	By uploadFileX = By.xpath("//input[@id='uploadname1']");
	By uploadToX = By.xpath("//select[@name='subdir1']");
	By subFolderX = By.xpath("//input[@id='newsubdir1']");
	By emailAddressX = By.xpath("//input[@id='formfield-email_address']");
	By firstNameX = By.xpath("//input[@id='formfield-first_name']");
	By uploadBtnX = By.xpath("//input[@id='uploadbutton']");
	By emailVerifyX = By.xpath("//dl[@id='fcuploadsummary']/dd[contains(text(),'Email Address')]");
	By firstNameVerifyX = By.xpath("//dl[@id='fcuploadsummary']/dd[contains(text(),'First Name')]");
	By imgNameVerifyX = By.xpath(".//*[@id='fcuploadsummary']/dt[contains(text(),'File 1 of 1')]/a");
	By viewUploadFileX = By.xpath("//div[@id='fcfooter-text']/a[contains(text(),'View')]");
	By folderListX = By.xpath("//table[@id='filelist']//tr[contains(@class,'dirrow')]//a[@title='']");
	By imgFileNameX = By.xpath("//a[@id='fclink-IMG03jpg']");
	By imgDetailX = By.xpath("//img[@class='fcthumb']");

	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");
		driver = new FirefoxDriver();
		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_Upload_File_By_Sendkeys() throws Exception {

		String pageUrl = "http://blueimp.github.com/jQuery-File-Upload/";

		System.out.println("TC01 : 1. Accces to Page : " + pageUrl);
		driver.get(pageUrl);

		System.out.println("TC01 : 2. Upload 3 Images ");
		uploadFileBySenkeyCommands(inputFileX, imgFile01Path);
		Thread.sleep(2000);

		uploadFileBySenkeyCommands(inputFileX, imgFile02Path);
		Thread.sleep(2000);

		uploadFileBySenkeyCommands(inputFileX, imgFile03Path);
		Thread.sleep(2000);

		System.out.println("TC01 : 3. Check IMG file is Added");
		checkAddFileSuccess(tableImgsX, imgFile01);
		Thread.sleep(2000);
		checkAddFileSuccess(tableImgsX, imgFile02);
		Thread.sleep(2000);
		checkAddFileSuccess(tableImgsX, imgFile03);
		Thread.sleep(2000);

		System.out.println("TC01 : 4. Click Start button to Upload Files");
		clickStartToUploadFile(tableImgsStartX);

		System.out.println("TC01 : 5. Verify Files are Uploaded Successfully !!!");
		checkUploadFileSuccess(tableImgsUploadedX, imgFile01);
		Thread.sleep(2000);
		checkUploadFileSuccess(tableImgsUploadedX, imgFile02);
		Thread.sleep(2000);
		checkUploadFileSuccess(tableImgsUploadedX, imgFile03);
		Thread.sleep(2000);

	}

	@Test
	public void TC04_Upload_File() throws Exception {

		String pageUrl = "https://encodable.com/uploaddemo/";

		System.out.println("TC04 : 1. Access to Page : " + pageUrl);
		driver.get(pageUrl);

		System.out.println("TC04 : 2. Choose file to Upload : ");
		uploadFileBySenkeyCommands(uploadFileX, imgFile03Path);

		System.out.println("TC04 : 3. Select Dropdown list ");
		Select uploadTo = new Select(driver.findElement(uploadToX));
		uploadTo.selectByVisibleText("/uploaddemo/files/");

		System.out.println("TC04 : 4. Input Random Folder");
		driver.findElement(subFolderX).sendKeys("Automation");

		System.out.println("TC04 : 5. Input Email Address and FirstName");
		driver.findElement(emailAddressX).sendKeys("automation@gmail.com");
		driver.findElement(firstNameX).sendKeys("automationtest");

		System.out.println("TC04 : 6. Click Upload Button");
		driver.findElement(uploadBtnX).click();
		Thread.sleep(3000);

		System.out.println("TC04 : 7. " + driver.findElement(emailVerifyX).getText());
		System.out.println("TC04 : 7. " + driver.findElement(firstNameVerifyX).getText());
		System.out.println("TC04 : 7. IMG file name : " + driver.findElement(imgNameVerifyX).getText());

		System.out.println("TC04 : 8. Click View Upload Files Link ");
		driver.findElement(viewUploadFileX).click();

		Thread.sleep(3000);
		System.out.println("TC04 : 9. Click to automation Folder ");
		List<WebElement> folderList = driver.findElements(folderListX);
		for (WebElement folder : folderList) {
			String folderName = folder.getText();
			if (folderName.equals("Automation")) {
				folder.click();
			}
		}
		Thread.sleep(3000);

		System.out.println("TC04 : 10 : Verify IMG file Name : " + driver.findElement(imgFileNameX).getText());

		System.out.println("TC04 : 11. Click to IMG Detail");
		driver.findElement(imgDetailX).click();
		Thread.sleep(3000);

		System.out.println("TC04 : 12. IMG link : " + driver.getCurrentUrl());
		System.out.println(
				"TC04 : 13. IMG name : " + driver.findElement(By.xpath("//div[@id='fc_content']/a")).getText());

	}

	public void uploadFileBySenkeyCommands(By by, String filePath) {

		WebElement fileInput = driver.findElement(by);
		fileInput.sendKeys(filePath);
	}

	public void checkAddFileSuccess(By by, String fileName) {

		List<WebElement> allFiles = driver.findElements(by);
		for (WebElement file : allFiles) {
			String name = file.getText();
			if (name.equals(fileName)) {
				System.out.println(fileName + " is Added Successfully !!!");
			} else {
				System.out.println("Failed to Add file " + fileName);
			}
		}
	}

	public void clickStartToUploadFile(By by) throws Exception {

		List<WebElement> allStartBtns = driver.findElements(by);
		for (WebElement startBtn : allStartBtns) {
			startBtn.click();
			Thread.sleep(2000);
		}
	}

	public void checkUploadFileSuccess(By by, String fileName) {

		List<WebElement> allUploaded = driver.findElements(by);
		if (allUploaded.size() > 0) {
			for (WebElement uploaded : allUploaded) {
				String name = uploaded.getText();
				if (name.equals(fileName)) {
					System.out.println(fileName + " is Uploaded Successfully !!!");
				} else {
					System.out.println("Failed to Upload file " + fileName);
				}

			}
		}
	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
