package example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Training {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\JyotsnaPatil\\chromedriver_win32\\chromedriver.exe");

		// Initialize browser
		WebDriver driver = new ChromeDriver();

		// Open facebook
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.name("firstName")).sendKeys("test");
		
		Select drp = new Select(driver.findElement(By.name("country")));
		drp.selectByIndex(5);
		
	
	}

}
