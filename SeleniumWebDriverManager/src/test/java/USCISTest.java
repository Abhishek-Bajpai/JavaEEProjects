
/**
 * https://github.com/bonigarcia/webdrivermanager
 * https://mvnrepository.com/
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class USCISTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\ExternalJars\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);

		WebDriver driver = new ChromeDriver(options);

		// driver.get("http://jenkins.bajpai.edu:8888/sampleapp/");
		driver.get("https://egov.uscis.gov/casestatus/landing.do");
		System.out.println(driver.getTitle());

		/*
		 * This is how you get to a div element .. provide class name like following
		 * example driver.findElement(By.xpath("//div[@class = '']")).click();
		 */

		
		  String[] caseNoStrings = { "LIN2030050994", "LIN2014450005", "LIN2090273519",
		  "LIN2030050970" };
		  
		  String firstCaseNo = "LIN2030050993"; String caseStatus; caseStatus =
		  getCaseStatus(driver, firstCaseNo);
		  System.out.println("\n----------------------------------------------\n");
		  System.out.println(firstCaseNo + " :  \n" + caseStatus +
		  "\n----------------------------------------------\n");
		  
		  for (String caseNo : caseNoStrings) { caseStatus = getMoreCaseStatus(driver,
		  caseNo);
		  System.out.println("\n----------------------------------------------\n"); if
		  (caseStatus.contains("Case Was Approved")) { System.out.println("\u001B[42m"
		  + caseStatus + "\u001B[40m"); } System.out.println(caseNo + " :  \n" +
		  caseStatus + "\n----------------------------------------------\n");
		  
		  }
		  
		driver.close();
		driver.quit();
	}

	private static String getCaseStatus(WebDriver driver, String string) {

		driver.findElement(By.id("receipt_number")).sendKeys(string);
		driver.findElement(By.name("initCaseSearch")).click();

		driver.getWindowHandle();
		WebElement webElement = driver.findElement(By.xpath("//div[@class = 'rows text-center']"));
		return webElement.getText();

	}

	private static String getMoreCaseStatus(WebDriver driver, String string) {

		driver.getWindowHandle();
		driver.findElement(By.id("receipt_number")).sendKeys(string);
		driver.findElement(By.name("caseStatusSearchBtn")).click();

		driver.getWindowHandle();
		WebElement webElement = driver.findElement(By.xpath("//div[@class = 'rows text-center']"));
		return webElement.getText();

	}

}
