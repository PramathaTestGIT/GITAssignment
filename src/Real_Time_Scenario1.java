import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Real_Time_Scenario1 {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\prama\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qatechhub.com");
		
		System.out.println("The title of the page is "+driver.getTitle());
		System.out.println("The Current URL of the page is "+driver.getCurrentUrl());
		driver.navigate().to("https://www.facebook.com");
		driver.navigate().back();
		System.out.println("The Current URL of the page is "+driver.getCurrentUrl());
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.quit();
		
	}
		

}
