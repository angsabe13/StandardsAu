package seleniumgluecode;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumgluecode.lib.AbstractTest;
import seleniumgluecode.lib.Customer;
import seleniumgluecode.lib.CustomerRegisterForm;
import seleniumgluecode.lib.JsonDataReader;

import org.junit.Assert;

public class test extends AbstractTest {
	JsonDataReader jsonData = null;
    Customer customer = null;
    CustomerRegisterForm registerForm = null;
	
	public test() {
		jsonData = new JsonDataReader();
	}
    
    @Given("^Customer logs in as customer \"(.*)\"$")
    public void customer_login_as_customer02(String customerId) throws Throwable {
        driver.get("https://www.commbank.com.au/");
        customer = jsonData.getCustomerById(customerId);
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
    	js_click(customer.accountType);
    	js_click(customer.isConcessionCardHolder ? "Yes" : "No");
    }
    
    @When("^user fills up Now tell us about yourself fields$")
    public void user_fills_up_now_tell_us_about_yourself_fields() throws Throwable {
    	registerForm = new CustomerRegisterForm(getDriver());
    	registerForm.enter_title(customer.title);
    	registerForm.enter_firstName(customer.firstName);
    	registerForm.enter_middleName(customer.middleName);
    	registerForm.enter_lastName(customer.lastName);
    	js_click("OK");
    }   
    
    @Then("^assertion here$")
    public void assertion_here() throws Throwable {
        Assert.assertEquals(customer.title, registerForm.getTitle());
        Assert.assertEquals(customer.firstName, registerForm.getFirstName());
        Assert.assertEquals(customer.middleName, registerForm.getMiddleName());
        Assert.assertEquals(customer.lastName, registerForm.getLastName());
    }

}