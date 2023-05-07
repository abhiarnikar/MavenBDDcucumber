package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import nopCommerce.pageObjects.AddNewCustomers;
import nopCommerce.pageObjects.Admin;

public class StepDefinations extends Base {
	@Given("user launch the browser")
	public void user_launch_the_browser() {
//		System.setProperty("webdriver.chrome.driver", "E:\\JavaSelenuim\\chromedriver_win32");
//	    driver=new ChromeDriver();
	    
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		driver=new ChromeDriver(chromeOptions);
	    
	    ad=new Admin(driver);
		
	}

	@Given("User visit the url {string}")
	public void user_visit_the_url(String url) throws Exception {
	   
		driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	@When("user enter the username {string} and Password {string}")
	public void user_enter_the_username_and_password(String email, String password) throws Exception {
	    
		ad.setUsername(email);
		ad.setPassword(password);
		Thread.sleep(2000);
	}

	@Then("user click on login button")
	public void user_click_on_login_button() throws Exception {
		
		ad.clickbtn();
		Thread.sleep(2000);
	   
	}

	@Then("validate the title {string}")
	public void validate_the_title(String title) throws Exception {
	    Assert.assertEquals(title, driver.getTitle());
	    Thread.sleep(2000);
	}

	@Then("close the browser")
	public void close_the_browser() {
	    driver.close();
		
	}
	
	//AddNewCustomers
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		addCust=new AddNewCustomers(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	    Thread.sleep(2000);
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() throws Exception {
		addCust.clickOnCustomesMenu();
	    Thread.sleep(2000);
	}

	@When("User click on customers menu item")
	public void user_click_on_customers_menu_item() throws Exception {
		addCust.clickOnCustomesMenuItem();
	    Thread.sleep(2000);
	}

	@When("User click on new add button")
	public void user_click_on_new_add_button() throws Exception {
		addCust.clickOnAddNew();
	    Thread.sleep(2000);
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws Exception {
		 Thread.sleep(2000);
	       Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String NewPassword, String firstName, String lastName, String gender, String compName, String adminComment) throws Exception {
		addCust.SetEmail(newEmail);
		  addCust.SetPassword(NewPassword);
		  addCust.SetFirstName(firstName);
		  addCust.SetLastName(lastName);
		  addCust.SetGender(gender);
		  addCust.SetCompanyName(compName);
		  addCust.SetAdminContent(adminComment);
		    Thread.sleep(2000);
	}

	@When("user click on save button")
	public void user_click_on_save_button() throws Exception {
		  addCust.clickOnSave();
		  Thread.sleep(2000);
	}

	@Then("User can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) throws Exception {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	    Thread.sleep(2000);
	}
	
}
