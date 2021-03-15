package seleniumgluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumgluecode.lib.AbstractTest;

import org.junit.Assert;

public class test extends AbstractTest {
    
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {
    	initialize();
        driver.get("https://www.commbank.com.au/");
    }
    
    @When("^user navigates to Banking then Everyday accounts$")
    public void user_navigates_to_banking_then_everyday_accounts() throws Throwable {
        click("Banking");
        click("Everyday accounts");
    }
    
    @When("^user clicks Open now for Smart Account Access$")
    public void user_clicks_open_now_for_smart_account_access() throws Throwable {
        driver.findElement(By.xpath("//a[@data-toggle='modal' and text()='Open now']")).click();
    }
    
    @When("^user navigates upto Now tell us about yourself form$")
    public void user_navigates_upto_now_tell_us_about_yourself_form() throws Throwable {
        driver.findElement(By.xpath("//a[@href='/banking/ready-to-apply.html?ei=%20btn-open-now-new']")).click();
        click("Get started");
    	click("OK");
    	js_click("Single");
    	js_click("No");
    }
    
    @When("^user fills up Now tell us about yourself fields$")
    public void user_fills_up_now_tell_us_about_yourself_fields() throws Throwable {
    	WebElement element = driver.findElement(By.id("Title"));
    	js_click(element);
    	scrollToView(element);   	
    	
        driver.findElement(By.xpath("//Option[@value='Mr']")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Anthony James");
        driver.findElement(By.id("MiddleNames")).sendKeys("between");
        driver.findElement(By.id("LastName")).sendKeys("User");
        click("OK");
    }   
    
    @Then("^assertion here$")
    public void assertion_here() throws Throwable {
        Assert.assertEquals("", "");
        driver.quit();  
    }
    

}