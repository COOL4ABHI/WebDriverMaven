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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {
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
		
		/*driver.get("http://way2automation.com/way2auto_jquery/index.php");
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle().length());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("country")).sendKeys("Greece");
		*/
		
		driver.get("https://www.wikipedia.org/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle().length());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		
		List<WebElement> list = driver.findElements(By.tagName("option"));
		System.out.println("Total no. of elements are : "+list.size());
		for (WebElement str:list) {
			System.out.println(str.getText());
		}
		System.out.println("-------------");
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getAttribute("lang"));
		}
		System.out.println("-------------");
		List<WebElement> list1 = driver.findElements(By.tagName("a"));
		System.out.println("Total links on page are :"+list1.size());
		System.out.println();
		for (WebElement str1:list1) {
			System.out.println(str1.getText()+"-----Links are --"+str1.getAttribute("href"));
		}
		System.out.println("-------------");
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		//*[@id="www-wikipedia-org"]/div[7]
		//*[@id="www-wikipedia-org"]/div[7]/div[3]
		List<WebElement> links = block.findElements(By.tagName("a"));
		System.out.println("Total links in block are :"+links.size());
		System.out.println();
		for (WebElement str2:links) {
			System.out.println(str2.getText()+"-----Links are --"+str2.getAttribute("href"));
		}
		driver.quit();
	}
}
