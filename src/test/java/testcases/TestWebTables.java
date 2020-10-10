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

public class TestWebTables {
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
		driver.get("https://money.rediff.com/gainers");
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle().length());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> rowNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("No of rows are : "+rowNum.size());
		List<WebElement> colNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println("No of cols are : "+colNum.size());
		
		for (int row=1;row<=rowNum.size();row++) {
			for (int col=1;col<=colNum.size();col++) {
				System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+row+"]/td["+col+"]")).getText()+"\t");
			}
			System.out.println();
			System.out.println("Row no. : "+row);
		}
	}
}
