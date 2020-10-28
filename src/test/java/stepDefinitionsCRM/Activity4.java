package stepDefinitionsCRM;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Activity4 {
	WebDriver driver;
	Actions action;

	@Given("^User is on SuitCRM$")
	public void Login() 
	{
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
	driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
	}

	@When("^Navigates to all Products$")
	public void navigateProducts() throws InterruptedException 
	{
	driver.findElement(By.cssSelector("#grouptab_5")).click();
	WebElement ActivitiesDropDown = driver.findElement(By.cssSelector("#grouptab_5")); 
	action = new Actions (driver);
	action.moveToElement(ActivitiesDropDown).click().build().perform();
	driver.findElement(By.xpath("//a[@href='?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DAOS_Products%26action%3Dindex%26parentTab%3DAll'][contains(.,'Products')]")).click();; 
	driver.findElement(By.xpath("//div[contains(text(),'Create Product')]")).click();
	}

	@And("^Enter production information with \"(.*)\" and \"(.*)\"$")

	public void enterInfo(String Productname, String Price) 
	{
	driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Productname);
	driver.findElement(By.xpath("//input[@id='price']")).sendKeys(Price);
	driver.findElement(By.xpath("//div[@class='buttons']//input[@id='SAVE']")).click();
	}

	@Then("^View Products \"(.*)\"$")

	public void viewproducts(String Productname) 
	{
	driver.findElement(By.xpath("//div[contains(text(),'View Products')]")).click();
	driver.findElement(By.partialLinkText(Productname)).isDisplayed();
	System.out.println(Productname + " created successfully");
	}

	@And("^Close browser$")

	public void close()
	{
	driver.close();
	}

}