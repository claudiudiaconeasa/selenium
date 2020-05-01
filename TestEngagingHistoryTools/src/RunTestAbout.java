import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunTestAbout 
{
	 static WebDriver webDriver;
	 
	 public static void main(final String[] args) throws InterruptedException 
     {
        System.setProperty("webdriver.chrome.driver","/Users/claudiudiaconeasa/Documents/Claudiu/selenium/TestHistoryTools/chromedriver/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        
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
}
