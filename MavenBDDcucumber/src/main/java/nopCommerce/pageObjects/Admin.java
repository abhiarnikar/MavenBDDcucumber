package nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin {
	
	public WebDriver ldriver;
	
	public Admin(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement EmailText;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement logbtn;
	
	public void setUsername(String uname) {
		
		EmailText.clear();
		EmailText.sendKeys(uname);
	}
	
	public void setPassword(String psw) {
		Password.clear();
		Password.sendKeys(psw);
	}
	
	public void clickbtn() {
		logbtn.click();
	}
		
}
