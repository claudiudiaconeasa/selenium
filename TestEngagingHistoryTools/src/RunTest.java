import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import org.openqa.selenium.By;

/**
 * @author Nils Schuette via frontendtest.org
 */
public class RunTest {
    static WebDriver webDriver;
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException 
    {
        System.setProperty("webdriver.chrome.driver","/Users/claudiudiaconeasa/Documents/Claudiu/selenium/TestHistoryTools/chromedriver/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        
        
        if(testCalendarButton())
        {
        	System.out.println("Prompted to - Form population will prompt to generate a calendar for History of Manchester University and City of Manchester");
        }
        
        else
        {
        	System.out.println("Prompted to - Can't get loader page ready to fetch the calendar for History of Manchester University and City of Manchester");
        }
        
        if(testCalendarButtonComputing())
        {
        	System.out.println("Form population will prompt to generate a calendar for History of Computing");
        }
        
        else
        {
        	System.out.println("Can't get loader page ready to fetch the calendar for History of Computing");
        }
        if(testAboutButton())
        {
        	System.out.println("Prompted to - 'About' section");
        }
      
        else
        {
        	System.out.println("Can't get loader page ready to fetch the calendar for History of Manchester University and City of Manchester");
        }
       
     
       
        webDriver.close();
        webDriver.quit();
    }
    
    public static boolean testAboutButton()
    {
    	webDriver.navigate().to("http://historytools.herokuapp.com/");

    	WebDriverWait wait = new WebDriverWait(webDriver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"about\"]")));
    	webDriver.findElement(By.xpath("//*[@id=\"about\"]")).click();
    	
    	if(webDriver.findElement(By.tagName("h2")).getText().equals("About"))
    	{
    		return true;
    	}
    	else { return false; }
    	    	
    }
    
    public static boolean testCalendarButton()
    {
    	webDriver.navigate().to("http://historytools.herokuapp.com/");

    	WebDriverWait wait = new WebDriverWait(webDriver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"generateHistory\"]")));
    	webDriver.findElement(By.xpath("//*[@id=\"generateHistory\"]")).click();
    	
    	if(webDriver.findElement(By.tagName("h2")).getText().equals("Status: Currently generating..."))
    	{
    		return true;
    	}
    	else { return false; }
    	    	
    }
    
    public static boolean testCalendarButtonComputing()
    { 
	    webDriver.navigate().to("http://historytools.herokuapp.com/");
	    
    	WebDriverWait wait = new WebDriverWait(webDriver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"generateComputing\"]")));
    	webDriver.findElement(By.xpath("//*[@id=\"generateComputing\"]")).click();
    	
    	if(webDriver.findElement(By.tagName("h2")).getText().equals("Status: Currently generating..."))
    	{
    		return true;
    	}
    	else { return false; }
   
    }
}