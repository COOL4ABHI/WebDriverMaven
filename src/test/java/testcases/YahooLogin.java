package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YahooLogin {
	
	public static WebDriver driver;
	public static String browser = "chrome";
	
public static void main(String[] args) {
		
	if (browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		;
		driver = new FirefoxDriver();
	} else if (browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		;
		driver = new ChromeDriver();
	} else if (browser.equals("ie")) {
		WebDriverManager.iedriver().setup();
		;
		driver = new InternetExplorerDriver();
	} else if(browser.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.get("https://login.yahoo.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login-username")).sendKeys("abhisheksharma.1410");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login-signin\"]"))).click();;
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id=\"login-passwd\"]")).sendKeys("12345");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login-passwd\"]"))).sendKeys("12345");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-passwd\"]"))).sendKeys("12345");
		driver.findElement(By.id("login-signin")).sendKeys(Keys.ENTER);;
		System.out.println(driver.findElement(By.className("/html/body/div[2]/div[2]/div[1]/div[2]/div[2]/form/p")).getText());
		//System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[2]/form/p"))).getText());
		driver.quit();
}
}
