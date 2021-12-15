import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;




public class Real_Time_Scenario3 {
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prama\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://yahoo.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		/*code for verifying "trending now" text and printing count of links n opening it */
		
		
		List<WebElement> linksTrendingNows=driver.findElements(By.cssSelector("li[class*='icon'] a"));
		
	    Assert.assertEquals(driver.findElement(By.className("s-label")).getText(), "Trending Now");

	    System.out.println("The Total number of links under Trending Now section is "+linksTrendingNows.size());
		 
		 for(int i=0;i<linksTrendingNows.size();i++)
		 {
		 
	     System.out.println(linksTrendingNows.get(i).getText());
		 
		 String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		 linksTrendingNows.get(i).sendKeys(clickonlinkTab); 
		 
		 }// opens all the tabs 
		 
		 
		 Set<String> allWindowHandles=driver.getWindowHandles();//4
		 Iterator<String> it=allWindowHandles.iterator(); 
		 
		 String parentId = it.next();
		 
		 while(it.hasNext())
		 
		 {
		 
		 driver.switchTo().window(it.next()); 
		 }
		 
		 driver.switchTo().window(parentId); 
		 
		 /* code for clicking on coronavirus table n scrolling to it n printing headers*/
			
		
		 driver.findElement(By.xpath("//div[@class='compCardList ps-quicklinks yui3-skin-sam']/ul/li[1]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		

		//WebElement coronaCountTable = driver.findElement(By.cssSelector(".coronavirusTable .compTableAdvance"));

		List<WebElement> coronaCountTableHead = driver.findElements(By.cssSelector(".dd.coronavirusTable thead tr th"));
	    for (int j=0;j<coronaCountTableHead.size();j++)
		
	     { 
		System.out.println("The header of columns is "+coronaCountTableHead.get(j).getText());
		
	     }
		
		driver.quit();
	}
}
