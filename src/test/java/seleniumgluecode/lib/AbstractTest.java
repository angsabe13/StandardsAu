package seleniumgluecode.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractTest {
    protected static WebDriver driver;
    protected static JavascriptExecutor jse;
    
    protected void initialize() {
    	System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
    	driver = new ChromeDriver();
    	jse = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    protected void scrollToView(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView('false');", element);
    }
    
	protected void click(String buttonName) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + buttonName + "']"))).click();
	}
	
	protected void js_click(String buttonName) {
		WebElement element = driver.findElement(By.xpath("//*[text()='" + buttonName + "']"));
		jse.executeScript("arguments[0].click()", element);
	}
	
	protected void js_click(WebElement element) {
		jse.executeScript("arguments[0].click()", element);
	}

}
