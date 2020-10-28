package stepDefinitionsHRM;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Activity3 {

	WebDriver driver;
    WebDriverWait wait;
    
	@Given("^Open the OrangeHRM Home page$")
		public void userOntheHomepage() throws Throwable {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
                
        //Open the browser
        driver.get("http://alchemy.hguy.co:8080/orangehrm");
        driver.manage().window().maximize();
	}
  	
	@When("^Login with credentials provided$")
		public void loginTothePage() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
	}
	
	@Then("^Find the PIM option in the menu and click it$")
		public void navigatePIMPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_pim_viewPimModule")));
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
	}
	
	@Then("^Go to Add Employee$")
		public void addEmp() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
	}
	
	@And("^When Fill the required values \"([^\"]*)\",\"([^\"]*)\"$")
	   public void fillReqVal(String arg1, String arg2) {
		driver.findElement(By.id("firstName")).sendKeys(arg1);
		driver.findElement(By.id("lastName")).sendKeys(arg2);
	}
	
	@Then("^Click on Create Login Details$")
			public void createLogin() {
		driver.findElement(By.id("chkLogin")).click();
	}
	
	@And("^fill other values \"([^\"]*)\" and Save$")
		public void fillOtherVal(String arg3) {
			driver.findElement(By.id("user_name")).sendKeys(arg3);
			driver.findElement(By.id("btnSave")).click();
	}
		
	@Then("^Go to Employee List$")
		public void emplList() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_pim_viewEmployeeList")));
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	}
	
  	@And("^Search the employee \"([^\"]*)\"$")
  		public void search(String arg4) {
  			driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(arg4);
  			driver.findElement(By.id("searchBtn")).click();
  	}
  	
  	@And("^Verify the employee \"([^\"]*)\"$")
  		public void verifyEmp(String arg5) {
  		String path = "//a[text()='"+arg5+"'";
  		Assert.assertEquals(driver.findElement(By.xpath(path)).getText().toString(), arg5);
  	}

  
	
}
