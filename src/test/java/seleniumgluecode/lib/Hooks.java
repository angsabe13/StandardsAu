package seleniumgluecode.lib;

import cucumber.api.java.After;
import cucumber.api.java.Before;
 
public class Hooks extends AbstractTest{
 
	@Before
    public void beforeScenario(){
 		initialize();
    } 
 
	@After
	public void afterScenario(){
		driver.quit();
	}
	
}