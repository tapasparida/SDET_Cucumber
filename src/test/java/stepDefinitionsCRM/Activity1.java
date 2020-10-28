package stepDefinitionsCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1 {
	 WebDriver driver;
	    WebDriverWait wait;
	    
	    @Given("^Open the browser to the Alchemy CRM site$")
	    public void userIsOnGooglePage() throws Throwable {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 15);
	                
	        //Open the browser
	        driver.get("https://alchemy.hguy.co/crm");
	        driver.manage().window().maximize();
	    }
	 
	   @When("^Users login$")
	   	  public void login() {
		   driver.findElement(By.id("user_name")).sendKeys("admin");
	        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	        driver.findElement(By.id("bigbutton")).click();
	   }
	   
	   @Then("^User counts dashlet and prints it$")
		 	public void printDashlet() {
		   java.util.List<WebElement> Dashlets = driver.findElements(By.className("dashlet-title"));
			
			System.out.println("Dashlets count is "+ Dashlets.size());
			for(int i=0;i<Dashlets.size();i++)
			{
				System.out.println(Dashlets.get(i).getText());
			}
	   }
		 
	   @And("^Close the browser$")
		public void closeBrowser()
		{
			driver.close();
		}

}
