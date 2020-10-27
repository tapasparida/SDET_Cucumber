package stepDefinitions_JobProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class jobBoard_jobPost {
	
	WebDriver driver;
	
	@Given ("^Open the Browser and visit Alchemy Jobsite \"(.*)\" and \"(.*)\"$")
	public void openBowserjobPost(String uName, String pWord){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		
		WebElement UserName = driver.findElement(By.id("user_login"));
		UserName.sendKeys(uName);
		WebElement UserPass = driver.findElement(By.id("user_pass"));
		UserPass.sendKeys(pWord);

		WebElement Login_Btn = driver.findElement(By.id("wp-submit"));
		Login_Btn.click();
	}
	
    @And ("^Post a job and fill in details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void fillJobDetails(String title,String location,String desc){
    	
    	driver.findElement(By.linkText("Alchemy Jobs")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.linkText("Post a Job")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
    	WebElement jobTitle = driver.findElement(By.xpath("//*[@id='job_title']"));
    	jobTitle.sendKeys(title);
    	
    	WebElement jobLocation = driver.findElement(By.id("job_location"));
    	jobLocation.sendKeys(location);
    	
    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
    	driver.switchTo().frame("job_description_ifr");
    	
    	
    	
    	
    	
    	WebElement jobDesc = driver.findElement(By.xpath("//*[@id='tinymce']"));
    	jobDesc.sendKeys("desc");
    	driver.switchTo().defaultContent();
    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)", "");
    }
    
    
    
    @When ("^Submit the job post$")
    
    
    public void submitJob() {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.xpath("//*[@name='submit_job']")).click();
    	driver.findElement(By.id("job_preview_submit_button")).click();
    	
    }
    
    @Then ("^Go to jobs page and validate the post$")
    public void validateJob() {
    	
    	driver.findElement(By.linkText("click here")).click();
    	String postname = driver.findElement(By.className("ast-single-post-order")).getText();
    	Assert.assertEquals("SDET QA Engineer", postname);
    	System.out.println("Job post validated successfully !!");
    }

}
