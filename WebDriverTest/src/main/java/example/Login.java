package example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class Login {
	@Test
	public void Read() {

		System.setProperty("webdriver.chrome.driver", "C:\\JyotsnaPatil\\chromedriver_win32\\chromedriver.exe");

		// Initialize browser
		WebDriver driver = new ChromeDriver();

		// Open facebook
		driver.get("http://www.Google.com");

		// implicit wait

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// Maximize browser
		driver.findElement(By.id("lst-ib")).sendKeys("abcd");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		driver.findElement(By.partialLinkText("Letters For Toddlers")).click();
		// driver.manage().window().maximize();

		String baseURL = "http://demo.guru99.com/test/newtours/register.php";
		driver.get(baseURL);
		driver.findElement(By.name("firstName")).sendKeys("asd");

		// dropdown value
		Select drp = new Select(driver.findElement(By.name("country")));
		drp.selectByIndex(5);
		// explicit wait
		// WebDriverWait explicitwait=new WebDriverWait(driver,10);
		// explicitwait.until(ExpectedConditions.titleContains("Mercury"));

		// Drag And Drop
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		WebElement from = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement to = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));

		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();

		WebElement from1 = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		WebElement to1 = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));

		act.dragAndDrop(from1, to1).build().perform();

		// tool tip verification
		driver.get("http://demo.guru99.com/test/social-icon.html");

		WebElement tooltip = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));
		String text = tooltip.getAttribute("title");
		System.out.println("**************" + text);

		String homePage = "https://www.youtube.com/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		driver = new ChromeDriver();

		// driver.manage().window().maximize();

		driver.get(homePage);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");

			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.close();

		}

	}
}
