import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunTestGenerateCalendarComputing {
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
	        
	       if(testCalendarButtonComputing())
	        {
	        	System.out.println("Form population will prompt to generate a calendar for History of Computing");
	        }
	        
	        else
	        {
	        	System.out.println("Can't get loader page ready to fetch the calendar for History of Computing");
	        }
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
