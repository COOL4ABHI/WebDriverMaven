package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowserIf {

	public static WebDriver driver;
	public static String browser = "ie";

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

		driver.get("https://accounts.google.com");
		driver.getTitle();
		driver.getTitle().length();
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle().length());
		driver.quit();
	}
}
