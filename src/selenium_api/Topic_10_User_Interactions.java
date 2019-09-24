package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_10_User_Interactions {

	WebDriver driver;

	By myntraDiscoverX = By.xpath("//a[@data-group='discover']");
	By myntraAmericanX = By.xpath("//a[@data-reactid='718']");

	By jqueryX = By.xpath("//ol[@id='selectable']/li");
	By jqueryExpX = By.xpath("//li[@class ='ui-state-default ui-selectee ui-selected']");

	By doubleClickX = By.xpath("//button[@ondblclick='doubleClickMe()']");
	By doubleClickResultX = By.xpath("//p[@id='demo']");

	By righClickX = By.xpath("//span[@class='context-menu-one btn btn-neutral']");
	By quitX = By.xpath("//span[text()='Quit']");

	By dragX = By.xpath("//div[@id='draggable']");
	By dropX = By.xpath("//div[@id='droptarget']");

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");

		driver = new FirefoxDriver();
		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_Mouse_To_Element() throws Exception {

		String pageUrl = "http://www.myntra.com/";
		String expResult = "American Eagle - Buy American Eagle Online in India | Myntra";
		driver.get(pageUrl);

		Actions action = new Actions(driver);
		WebElement leftMenu = driver.findElement(myntraDiscoverX);
		action.moveToElement(leftMenu).perform();
		System.out.println("TC01 : 1. Hover to Discover Tab");

		driver.findElement(myntraAmericanX).click();
		System.out.println("TC01 : 2. Click to American Eagle link");

		Thread.sleep(2000);

		Assert.assertEquals(driver.getTitle(), expResult);

	}

	@Test
	public void TC02_Click_And_Hold_Element() throws Exception {

		String pageUrl = "http://jqueryui.com/resources/demos/selectable/display-grid.html";
		driver.get(pageUrl);

		List<WebElement> allItem = driver.findElements(jqueryX);
		Actions action = new Actions(driver);

		action.clickAndHold(allItem.get(0)).moveToElement(allItem.get(3)).release().perform();
		Thread.sleep(2000);

		List<WebElement> selectedItem = driver.findElements(jqueryExpX);

		Assert.assertEquals(selectedItem.size(), 4);
	}

	@Test
	public void TC03_Click_Select_Element() throws Exception {

		String pageUrl = "http://jqueryui.com/resources/demos/selectable/display-grid.html";
		driver.get(pageUrl);

		List<WebElement> allItem = driver.findElements(jqueryX);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).perform();
		allItem.get(0).click();
		Thread.sleep(2000);
		allItem.get(3).click();
		Thread.sleep(2000);
		allItem.get(5).click();
		Thread.sleep(2000);
		action.keyUp(Keys.CONTROL).perform();

		List<WebElement> selectedItem = driver.findElements(jqueryExpX);

		Assert.assertEquals(selectedItem.size(), 3);
	}

	@Test
	public void TC04_Double_Click() throws Exception {

		String pageUrl = "https://automationfc.github.io/basic-form/";
		String expResult = "Hello Automation Guys!";
		driver.get(pageUrl);

		WebElement doubleClick = driver.findElement(doubleClickX);
		Actions action = new Actions(driver);
		action.doubleClick(doubleClick).perform();
		Thread.sleep(3000);

		Assert.assertEquals(driver.findElement(doubleClickResultX).getText(), expResult);

	}

	@Test
	public void TC05_Right_Click() throws Exception {

		String pageUrl = "http://swisnl.github.io/jQuery-contextMenu/demo.html";
		driver.get(pageUrl);

		WebElement rightClick = driver.findElement(righClickX);

		Actions action = new Actions(driver);
		action.contextClick(rightClick).perform();
		Thread.sleep(3000);

		WebElement quit = driver.findElement(quitX);
		action.moveToElement(quit).perform();
		Thread.sleep(3000);

		Assert.assertEquals(quit.isDisplayed(), true);

	}

	@Test
	public void TC06_Drag_And_Drop() throws Exception {

		String pageUrl = "http://demos.telerik.com/kendo-ui/dragdrop/angular";
		String expResult = "You did great!";
		driver.get(pageUrl);

		WebElement drag = driver.findElement(dragX);
		WebElement drop = drag.findElement(dropX);
		Actions action = new Actions(driver);

		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);

		Assert.assertEquals(drop.getText(), expResult);

	}

	@Test
	public void TC07_Drag_And_Drop_HTML5() {

		String pageUrl = "http://the-internet.herokuapp.com/drag_and_drop";
		driver.get(pageUrl);
	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
