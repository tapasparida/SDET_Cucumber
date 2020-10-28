/*
 * package stepDefinitionsHRM;
 * 
 * 
 * 
 * import org.junit.Assert; import org.openqa.selenium.By; import
 * org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.Select; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import io.cucumber.java.en.And; import io.cucumber.java.en.Given; import
 * io.cucumber.java.en.Then; import io.cucumber.java.en.When;
 * 
 * 
 * 
 * public class Activity4 {
 * 
 * WebDriver driver; WebDriverWait wait;
 * 
 * @Given("^Open the HRM page$") public void userIsOnHRMPage4() throws Throwable
 * { //Create a new instance of the Firefox driver driver = new ChromeDriver();
 * wait = new WebDriverWait(driver, 15);
 * 
 * //Open the browser driver.get("http://alchemy.hguy.co:8080/orangehrm");
 * driver.manage().window().maximize();
 * driver.findElement(By.id("txtUsername")).sendKeys("orange");
 * driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
 * driver.findElement(By.id("btnLogin")).click(); }
 * 
 * @When("^Navigate to the recruitment page$") public void
 * navigateRecruitmentPage4() {
 * driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
 * 
 * }
 * 
 * @And("^Click on the “Vacancies” menu item to navigate to the vacancies page$"
 * ) public void vacanciesMenu4() {
 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(
 * "menu_recruitment_viewJobVacancy")));
 * driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click(); }
 * 
 * @And("^Click on the “Add” button to navigate to the “Add Job Vacancy” form$")
 * public void addJobVacany4() {
 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnAdd"
 * ))); driver.findElement(By.id("btnAdd")).click(); }
 * 
 * @Then("^Fill out the necessary details$") public void
 * fillNecessayDetails(String jobVacancy, String hiringManager) {
 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(
 * "addJobVacancy_jobTitle"))); Select dropDown = new
 * Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
 * dropDown.selectByVisibleText("DevOps Engineer");
 * driver.findElement(By.id("addJobVacancy_name")).sendKeys(jobVacancy);
 * driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(
 * hiringManager);
 * 
 * }
 * 
 * @And("^Click the “Save” button to save the vacancy$") public void save4() {
 * driver.findElement(By.id("btnSave")).click(); }
 * 
 * @Then("^Verify that the vacancy was created$") public void
 * verifyVacancy4(String jobVacancy,String hiringManager) {
 * driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click(); Select
 * dropDown = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
 * dropDown.selectByVisibleText("DevOps Engineer"); Select dropDown1 = new
 * Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
 * dropDown1.selectByVisibleText("Engineer"); Select dropDown2 = new
 * Select(driver.findElement(By.id("vacancySearch_hiringManager")));
 * dropDown2.selectByVisibleText(hiringManager);
 * driver.findElement(By.id("btnSrch")).click(); String path =
 * "//a[text()='"+jobVacancy+"'";
 * Assert.assertEquals(driver.findElement(By.xpath(path)).getText().toString(),
 * jobVacancy);
 * 
 * }
 * 
 * @And("^Close the browser4$") public void closeTheBrowser() throws Throwable {
 * driver.close(); } }
 */