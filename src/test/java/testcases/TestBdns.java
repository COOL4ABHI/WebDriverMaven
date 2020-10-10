package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBdns {
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
	
		driver.get("http://test.bdns.in/login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.id("txtDataBaseName")).sendKeys("11");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("txtName")).sendKeys("Abhi");
		driver.findElement(By.id("txtNoOfRecord")).sendKeys("500");
		driver.findElement(By.id("btnGet")).click();
		driver.findElement(By.id("btnSave1")).click();
		//driver.findElement(By.id("txtDataBaseName")).sendKeys("11");
		
		//driver.close();
}}
