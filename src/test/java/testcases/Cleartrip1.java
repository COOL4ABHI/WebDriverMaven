package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cleartrip1 {
	public static WebDriver driver;
	public static String browser = "chrome";
	public static String fromPlace = "New Delhi";
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("cleartrip");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='g']//div//div[@class='rc']//h3[@class='LC20lb DKV0Md'][contains(text(),'Cleartrip')]")).click();
		driver.findElement(By.xpath("//input[@id='RoundTrip']")).click();
		WebElement ele = driver.findElement(By.id("FromTag"));
		Select select = new Select(ele);
		select.selectByVisibleText(fromPlace);
		/*List<WebElement> ele = driver.findElements(By.tagName("a"));
		for (WebElement place:ele) {
			System.out.println("Name of places are "+place.getAttribute());
		*/	
		}
		
	}

