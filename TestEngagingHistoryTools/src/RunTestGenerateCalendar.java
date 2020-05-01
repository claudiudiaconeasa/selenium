import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunTestGenerateCalendar {
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

}
