package seleniumgluecode.lib;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
 
public class Hooks extends AbstractTest{
 
	@Before
    public void beforeScenario(){
 		initialize();
    } 
 
	@After
	public void afterScenario(Scenario scenario){
		takeScreenshot(scenario);
		driver.quit();
	}
	
	private void takeScreenshot(Scenario scenario) {
		System.out.println("scenario.isFailed(): " + scenario.isFailed());
		if (scenario.isFailed()) {
	        try {
	        	byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            String testName = scenario.getName();
	            scenario.embed(screenshot, "image/png");
	            scenario.write(testName);
	        } catch (WebDriverException wde) {
	            System.err.println(wde.getMessage());
	        } catch (ClassCastException cce) {
	            cce.printStackTrace();
	        }
		}
	}
}