package stepDefinitionsCRM;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Activity3 {
	WebDriver driver;
	Actions action;
	@Given("^suitCRM site is logged in to$")
	public void Login() 
	{
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
	driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
	}

	@When("^User schedules a meeting$")

	public void SceduleMeeting() throws InterruptedException 
	{
	driver.findElement(By.xpath("//a[@id='grouptab_3']")).click();
	WebElement ActivitiesDropDown = driver.findElement(By.xpath("//a[@id='grouptab_3']")); 
	action = new Actions (driver);
	action.moveToElement(ActivitiesDropDown).click().build().perform();
	WebElement Meetings = driver.findElement(By.xpath("//a[@id='moduleTab_9_Meetings']")); 
	action.moveToElement(Meetings).click().build().perform();
	driver.findElement(By.xpath("//div[contains(text(),'Schedule Meeting')]")).click();
	driver.findElement(By.id("name")).sendKeys("CucumberCRM");
	} 

	@And("^searches for Members and adds them$")

	public void addMembers(DataTable Members) 
	{

	List<List<String>> data = Members.asLists();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)");
	driver.findElement(By.xpath("//input[@id='search_first_name']")).sendKeys(data.get(0).get(0));
	driver.findElement(By.xpath("//input[@id='invitees_search']")).click();
	driver.findElement(By.xpath("//input[@id='invitees_add_1']")).click();
	driver.findElement(By.xpath("//input[@id='search_first_name']")).clear();
	driver.findElement(By.xpath("//input[@id='search_first_name']")).sendKeys(data.get(1).get(0));
	driver.findElement(By.xpath("//input[@id='invitees_search']")).click();
	driver.findElement(By.xpath("//input[@id='invitees_add_1']")).click();
	driver.findElement(By.xpath("//input[@id='search_first_name']")).clear();
	driver.findElement(By.xpath("//input[@id='search_first_name']")).sendKeys(data.get(2).get(0));
	driver.findElement(By.xpath("//input[@id='invitees_search']")).click();
	driver.findElement(By.xpath("//input[@id='invitees_add_1']")).click();
	driver.findElement(By.cssSelector("#SAVE_HEADER")).click();
	}

	@Then("^view meeting page$")
	public void viewMeeting() 
	{
	driver.findElement(By.xpath("//div[contains(text(),'View Meetings')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'CucumberCRM')]")).isDisplayed();
	System.out.println("Meeting scheduled successfully");
	}

	@And("^closes the browser$")
	public void close()
	{
	driver.close();
	}

  }
