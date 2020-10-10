package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
		driver.get("https://gmail.com");
		//String title = driver.getTitle();
		//System.out.println(title);
		/*WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("abhitech.busy");
		WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
		nextButton.click();*/
		driver.findElement(By.id("identifierId")).sendKeys("abhitech.busy");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		
		//driver.quit();*/	
	}

}
