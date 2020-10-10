package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	
	public static WebDriver driver;
	public static String browser = "chrome";
	String opt;
	
	
	public static int sumResult (int a,int b,int c,String opt) {
	if(opt.equals("+")) {
		c = a+b;
		return c;
	} else if (opt.equals("-")) {
		c = a-b;
		return c;
	} else if (opt.equals("*")) {
		c = a*b;
		return c;
	}
	return c;
}
	
	public static void main(String[] args) {
		//Assignment3 value = new Assignment3();
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		String captcha = driver.findElement(By.id("mathq2")).getText();
		System.out.println("Captcha is : "+captcha);
		System.out.println("Length of Captha is :"+captcha.length());
		String str1 = captcha.substring(0, 1);
		//System.out.println(str1);
		int var1 = Integer.parseInt(str1);
		System.out.println("Value of Var1 is :"+var1);
		String opt = captcha.substring(2, 3);
		System.out.println("Operator is :"+opt);
		String str2 = captcha.substring(4, 5);
		//System.out.println(str2);
		int var2 = Integer.parseInt(str2);
		System.out.println("Value of Var2 is :"+var2);
		int total=0;
		int totalval = sumResult(var1, var2, total, opt);
		System.out.println("Value holds :"+totalval);
		System.out.println(totalval);
		//System.out.println(totalval.toString());
		String val = String.valueOf(totalval);
		System.out.println(val);
		driver.findElement(By.id("mathuserans2")).sendKeys(val);
		
	}

}
