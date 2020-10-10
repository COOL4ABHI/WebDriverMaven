package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyBoardEvents {
	public static WebDriver driver;
	public static String browser = "chrome";
	
	public static void main(String[] args) {
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys("abhitech.busy");
		//driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div")).click();
		driver.findElement(By.id("identifierId")).click();
		Actions action = new Actions(driver);
		//action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"A")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"C")).perform();
		driver.findElement(By.id("identifierId")).click();
		driver.findElement(By.id("identifierId")).clear();
		action.sendKeys(Keys.chord(Keys.CONTROL+"V")).perform();
		
}
}