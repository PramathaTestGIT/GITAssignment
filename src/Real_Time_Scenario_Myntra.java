import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Real_Time_Scenario_Myntra {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prama\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		/*code for selecting from women section-->tops->*/
		
		Actions a=new Actions(driver);
		WebElement moveToWomen=driver.findElement(By.cssSelector("a[data-group='women']"));
		
		a.moveToElement(moveToWomen).build().perform();
	
		driver.findElement(By.xpath("//a[@href='/tops']")).click();
		WebElement sortByDropDown = driver.findElement(By.className("sort-sortBy"));
		a.moveToElement(sortByDropDown).click().build().perform();
		
		/*code for selecting "Whats new" from the dropdown*/
		
		List<WebElement> allOptionsDropdowns = sortByDropDown.findElements(By.cssSelector(".sort-label"));

	//	List<WebElement> allOptionsDropdowns = sortByDropDown.findElements(By.cssSelector("label[class='sort-label ']"));
        for(int i = 0; i<=allOptionsDropdowns.size()-1; i++) 
        {
        	
           if(allOptionsDropdowns.get(i).getText().contains("What's New")) 
           {
        	
           allOptionsDropdowns.get(i).click();
           break;     
        
           }
        }

        /*code for selecting Brand,Discount range,Price*/
        
        a.moveToElement(driver.findElement(By.xpath("//ul[@class='brand-list']/li[3]"))).click().build().perform();
  
        a.moveToElement(driver.findElement(By.xpath("//ul[@class='discount-list']/li[2]"))).click().build().perform();
    
     
        a.moveToElement(driver.findElement(By.xpath("//ul[@class='price-list']/li[2]"))).click().build().perform();
   
     
        a.moveToElement(driver.findElement(By.xpath("//ul[@class='results-base']/li[5]"))).click().build().perform();
       
        
        
        Set<String> allWindowHandles=driver.getWindowHandles();//4
		 Iterator<String> it=allWindowHandles.iterator(); 
		 
		 String parentId = it.next();
		 
		 while(it.hasNext())
		 
		 {
		 
		 driver.switchTo().window(it.next()); 
		 }
		 
		/*Code for choosing the Product,putting it in Bag ,going to bag and wishlisting it*/
		 @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sizeButtonsContainer']/div[2]/div[4]/div/button")));
		 
        a.moveToElement(driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']/div[2]/div[4]/div/button"))).click().build().perform();
        a.moveToElement(driver.findElement(By.className("pdp-add-to-bag"))).click().build().perform();

        
        a.moveToElement(driver.findElement(By.className("desktop-cart"))).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("itemComponents-base-toolTipCTA"))));
       
        a.moveToElement(driver.findElement(By.className("itemComponents-base-toolTipCTA"))).click().build().perform();
    
        a.moveToElement(driver.findElement(By.xpath("//button[@class='inlinebuttonV2-base-actionButton bulkActionStrip-desktopBulkWishlist']"))).click().build().perform();
        
        a.moveToElement(driver.findElement(By.cssSelector(".inlinebuttonV2-base-actionButton.bulkActionStrip-waterMelon"))).click().build().perform();
        
       driver.quit();
 
      }
}
	
		  
       
		
		


