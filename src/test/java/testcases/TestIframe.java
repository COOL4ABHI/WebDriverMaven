package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIframe {
	public static WebDriver driver;
	public static String browser = "chrome";
	
	public static void screenshot() throws IOException {
		Date d = new Date();
		String stamp = d.toString().replace(":","");
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".\\screenshot\\error"+stamp+".jpg"));
	}

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
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		// we can also call function to execute a java script
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("myFunction()");
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(By.xpath("//button[contains(text(),'Try it')]")));
		driver.switchTo().defaultContent();
		List<WebElement> list = driver.findElements(By.tagName("iframe"));
		System.out.println(list.size());
		System.out.println("--------------");
		for (WebElement str:list) {
			System.out.println(str.getAttribute("id"));
		}
		screenshot();
		//driver.switchTo().frame(1);
		//driver.close();
	}
}