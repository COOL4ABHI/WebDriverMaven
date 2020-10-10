package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {
	public static void main(String[] args) {
		// System.setProperty("webdriver.gecko.driver", "F:\\Selenium
		// Prerequisites\\geckodriver.exe");
		/*
		 * WebDriverManager.firefoxdriver().setup(); FirefoxDriver driver = new
		 * FirefoxDriver(); driver.get("https://accounts.google.com"); String title =
		 * driver.getTitle(); System.out.println(title.length());
		 * System.out.println(title); //driver.close(); driver.quit();
		 */

		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver1 = new
		 * ChromeDriver(); driver1.get("https://accounts.google.com"); String title =
		 * driver1.getTitle(); System.out.println(title.length());
		 * System.out.println(title); //driver.close(); driver1.quit();
		 */

		// System.setProperty("webdriver.ie.driver","F:\\Selenium
		// Prerequisites\\IEDriverServer.exe");
		// InternetExplorerDriver driver = new InternetExplorerDriver();
		// driver.get("https://accounts.google.com");

		//System.setProperty("webdriver.edge.driver", "F:\\Selenium Prerequisites\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://accounts.google.com");

	}
}
