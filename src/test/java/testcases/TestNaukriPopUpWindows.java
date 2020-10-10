package testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNaukriPopUpWindows {
	public static WebDriver driver;
	public static String browser = "chrome";
	
	
	public static void main(String[] args) throws IOException {
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		//first window
		driver.get("https://www.naukri.com/");

		Set<String> window = driver.getWindowHandles();
		System.out.println("No. of windows : "+window.size());
		Iterator<String> itr = window.iterator();
		String firstWindow = itr.next();
		
		System.out.println("First window ID is "+firstWindow);
		System.out.println("First window title is "+driver.getTitle());
		
		System.out.println("-----second window-----");
		window = driver.getWindowHandles();
		itr = window.iterator();
		itr.next();
		String secondWindow = itr.next();
		System.out.println("Second window ID is "+secondWindow);
		driver.switchTo().window(secondWindow);
		System.out.println("Second window title is "+driver.getTitle());
		
		System.out.println("-----third window-----");
		//driver.switchTo().defaultContent();
		window = driver.getWindowHandles();
		itr = window.iterator();
		itr.next();
		itr.next();
		String thirdWindow = itr.next();
		//while(iterate.hasnext()) {
			//iterate.next();
		//}
		System.out.println("Third window ID is "+thirdWindow);
		driver.switchTo().window(thirdWindow);
		System.out.println("Third window title is "+driver.getTitle());
		
		driver.switchTo().defaultContent();
		driver.quit();
	}
}