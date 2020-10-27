package stepDefinitions_JobProject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;

public class jobSearch {
	WebDriver driver;
	
	@Given("^Open the Browser and go to Job Board site \"(.*)\" and \"(.*)\"$")
	public void openBrowser(String uName, String pWord) {
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

	@And ("^Find Search input search jobs change jobtype$")
	public void jobSearch() {
		
		driver.findElement(By.linkText("Alchemy Jobs")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id='menu-item-24']/a")).click();
		WebElement search = driver.findElement(By.id("search_keywords"));
		search.clear();search.sendKeys("SDET QA");
		driver.findElement(By.xpath("//*[@class='search_submit']/input")).click();
		
		List<WebElement> chkBox_List =driver.findElements(By.xpath("//*[@class='job_types']/li"));
			for(WebElement a : chkBox_List)
				if(!a.getText().contentEquals("Full Time"))
				a.click();
			;
			driver.findElement(By.xpath("//*[@class='search_submit']/input")).click();
		
	}

@When ("^Filter Fulltime jobs$")
public void filterJob() {
	
	List<WebElement> chkBox_List =driver.findElements(By.xpath("//*[@class='job_types']/li"));
	for(WebElement a : chkBox_List)
		if(!a.getText().contentEquals("Full Time"))
		a.click();
	
	driver.findElement(By.xpath("//*[@class='search_submit']/input")).click();


}
@And ("^Find job listing and job details$")
public void jobDetails() {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.xpath("//*[@class='job_listings']/li/a")).click();
	String jobTitle = driver.findElement(By.xpath("//*[@class='ast-single-post-order']/h1")).getText();
	System.out.println(jobTitle);
	
}

@Then ("^Apply job$")
public void applyJob() {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebElement applyJob = driver.findElement(By.xpath("//*[@class='job_application application']/input"));
	applyJob.click();
	
}
@And ("^Close  the Browser$")
public void closeBrw() {
	driver.close();
}
}
