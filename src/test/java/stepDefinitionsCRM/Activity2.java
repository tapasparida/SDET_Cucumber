package stepDefinitionsCRM;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Activity2 {
	WebDriver driver;
	WebDriverWait wait;

	 @Given("^Open the browser to the Alchemy CRM site$")
	    public void userIsOnGooglePage() throws Throwable {
	        //Create a new instance of the Firefox driver
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, 15);
	                
	        //Open the browser
	        driver.get("https://alchemy.hguy.co/crm");
	        driver.manage().window().maximize();
	        driver.findElement(By.id("user_name")).sendKeys("admin");
	        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	        driver.findElement(By.id("bigbutton")).click();
	    }
	 
	   
	@When("^User Creates Lead with \"(.*)\"$")
		public void NavigatetoCreateLead(String lastname) throws InterruptedException {
			driver.findElement(By.cssSelector("a[id=\'grouptab_0\']")).click();
			WebElement SalesDropDown = driver.findElement(By.cssSelector("a[id=\'grouptab_0\']"));
			Actions action = new Actions (driver);
			action.moveToElement(SalesDropDown).click().build().perform();
			WebElement Lead = driver.findElement(By.cssSelector("a[id=\'moduleTab_9_Leads\']")); 
			action.moveToElement(Lead).click().build().perform();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[1]//a[1]//div[2]")));
			driver.findElement(By.xpath("//li[1]//a[1]//div[2]")).click();
			driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(lastname);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[@class='buttons']//div[@class='buttons']//input[@id='SAVE']")));
			driver.findElement(By.xpath("//td[@class='buttons']//div[@class='buttons']//input[@id='SAVE']")).click();
	}

	@Then("^Views Leads page to see result with \"(.*)\"$")
		public void viewResult(String lastname) {
			driver.findElement(By.xpath("//div[contains(text(),'View Leads')]")).click();
			driver.findElement(By.partialLinkText(lastname)).isDisplayed();
			System.out.println(lastname+" lead created successfully");
	}

	@And("^Closes the browser$")
		public void close()
		{
		driver.close();
		}

}