package testcases;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckbox {
	
	public static WebDriver driver;
	public static String browser = "chrome";
	
	public static Boolean isElementPresent(By by) {
		try {
		driver.findElement(by);
		return true;
	} catch (Throwable t) {
		return false;
	}}

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
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle().length());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.findElement(By.xpath("//div[4]/input[1]")).click();
		driver.findElement(By.xpath("//div[4]/input[2]")).click();
		driver.findElement(By.xpath("//div[4]/input[3]")).click();
		driver.findElement(By.xpath("//div[4]/input[4]")).click();*/
		/*
		System.out.println("--------------------");
		for (int i=1;i<5;i++) {
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		}
		*/
		/*
		System.out.println("--------------------");
		 
		int j=1;
		int k=0;
		while(isElementPresent(By.xpath("//div[4]/input["+j+"]"))) {
			driver.findElement(By.xpath("//div[4]/input["+j+"]")).click();
			k++;
			j++;
		}
		System.out.print("Total number of checkboxes are : "+k);
		*/
		WebElement firstFrame = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		
		List<WebElement> checkbox = firstFrame.findElements(By.name("sports"));
		System.out.print("Total number of checkboxes are : "+checkbox.size());
		for (WebElement check:checkbox) {
			check.click();
		}
	}
}
