package seleniumgluecode.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegisterForm extends AbstractTest{
	
	WebDriver driver = null;
	
	public CustomerRegisterForm (WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "Title") 
	private WebElement title;
	
	@FindBy(how = How.ID, using = "FirstName") 
	private WebElement firstName;
	
	@FindBy(how = How.ID, using = "MiddleNames") 
	private WebElement middleName;
	
	@FindBy(how = How.ID, using = "LastName") 
	private WebElement lastName;
	
	@FindBy(how = How.ID, using = "email") 
	private WebElement email;
	
	@FindBy(how = How.ID, using = "mobile") 
	private WebElement mobile;
    
    public void enter_title(String value) {
    	js_click(title);
        driver.findElement(By.xpath("//Option[@value='" + value + "']")).click();
    }
    
    public void enter_firstName(String value) {
    	firstName.sendKeys(value);
    }
    
    public void enter_middleName(String value) {
    	middleName.sendKeys(value);
    }
    
    public void enter_lastName(String value) {
    	lastName.sendKeys(value);
	}
    
    public void enter_email(String value) {
    	email.sendKeys(value);
	}
    
    public void enter_mobile(String value) {
    	mobile.sendKeys(value);
	}
    
    public String getTitle() {
    	return (String)jse.executeScript("return nameForm.title.value");
    }
    
    public String getFirstName() {
    	return (String)jse.executeScript("return nameForm.firstName.value");
    }
    
    public String getMiddleName() {
    	return (String)jse.executeScript("return nameForm.middleNames.value");
    }
    
    public String getLastName() {
    	return (String)jse.executeScript("return nameForm.lastName.value");
    }


}
