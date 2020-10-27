package stepDefinitions_JobProject;



import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class jobBoard_NewUser {

	WebDriver driver;
	

	@Given("^Open Browser and go to Job Board site$")
	public void jobBoardlaunch() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");

	}

	
	@When("^User entered username and password \\\"(.*)\\\" and \\\"(.*)\\\"$")

	public void login(String uName, String pWord) {

		WebElement UserName = driver.findElement(By.id("user_login"));
		UserName.sendKeys(uName);
		WebElement UserPass = driver.findElement(By.id("user_pass"));
		UserPass.sendKeys(pWord);

		WebElement Login_Btn = driver.findElement(By.id("wp-submit"));
		Login_Btn.click();

	}

	@Then("^Create New User from left menu on landing page \"(.*)\" and \\\"(.*)\\\"$")

	public void createUser(String NewUser, String eMail)  {
		
		
		
		driver.findElement(By.linkText("Users")).click();
		
		driver.findElement(By.xpath("//div[@class='wrap']/a")).click();
		driver.findElement(By.id("user_login")).sendKeys(NewUser);
		driver.findElement(By.id("email")).sendKeys(eMail);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	
	@And("^Click Add New User button$")

	public void clickAddNewUserButton()  {
	driver.findElement(By.id("createusersub")).click();

	}
	
	@And("^Assert User \"(.*)\"$")
	
	public boolean assert_user(String uNameAssert) {
		WebElement webTable = driver.findElement(By.tagName("table"));
	    for(WebElement row : webTable.findElements(By.tagName("tr"))) {
	        if(row.getText().contains(uNameAssert)) {
	        	
	            return true;
	          
	        }
	         
	    }
	    return false;

}
	
	
	  @And("^Close  Browser$")
	  
	  public void closeit() { driver.close(); }
	 
	
}

