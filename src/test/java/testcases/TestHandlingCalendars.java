package testcases;

import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingCalendars {
	public static WebDriver driver;
	public static String browser = "firefox";
	
	static int targetDate = 0,
			targetMonth = 0,
			targetYear = 0;
	
	static int currentDay = 0,
			currentMonth = 0,
			currentYear = 0;
	
	static int jumpMonthBy = 0;
	
	static boolean increment = true;
	
	public static void calculateDateMonthAndYear() {
		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH)+1;
		currentYear = cal.get(Calendar.YEAR);
	}
	 public static void calculateMonthDiff() {
		 if ((targetMonth-currentMonth)>0) {
			 jumpMonthBy = targetMonth-currentMonth;
		 } else {
			 jumpMonthBy = currentMonth-targetMonth;
			 increment = false;
		 }
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
		
		driver.get("");
		String dateToSet = "16/08/2020";
		//get current date
		calculateDateMonthAndYear();
		System.out.println("Current Date : "+currentDay+"/"+currentMonth+"/"+currentYear);
		//get target date
		targetDate = Integer.parseInt(dateToSet.substring(0, 2));
		targetMonth= Integer.parseInt(dateToSet.substring(3, 5));
		targetYear = Integer.parseInt(dateToSet.substring(6, 10));
		System.out.println("Target Date : "+targetDate+"/"+targetMonth+"/"+targetYear);
		
		//Jumpto month
		calculateMonthDiff();
		System.out.println("Jump month by : "+jumpMonthBy);
		System.out.println(increment);
	}	
}