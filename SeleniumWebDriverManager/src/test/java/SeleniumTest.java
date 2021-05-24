/**
 * https://github.com/bonigarcia/webdrivermanager
 * https://mvnrepository.com/
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {


	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		
		
		WebDriver driver = new ChromeDriver(options);	

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://jenkins.bajpai.edu:8888/sampleapp/");
		
		System.out.println("Title of the page~ " + driver.getTitle());
		
		
		/**
		 * Add a new contact
		 */
		//This is how you get to a div element .. provide class name like following example 
		//driver.findElement(By.xpath("//div[@class = '']")).click();
   		  driver.findElement(By.xpath("//div[@class = 'v-button v-widget']")).click();
		  driver.findElement(By.id("gwt-uid-5")).sendKeys("Abhishek"); // First Name
		  driver.findElement(By.id("gwt-uid-7")).sendKeys("Bajpai"); // Last Name
		  driver.findElement(By.id("gwt-uid-9")).sendKeys("5105572786"); // Phone
		  driver.findElement(By.id("gwt-uid-11")).sendKeys("abba.ca07@gmail.com"); //Email
//		  driver.findElement(By.id("gwt-uid-13")).sendKeys("03/12/1976");   // Birth Date
		
   		  
   		  //driver.findElement(By.xpath("//div[@class = 'v-button v-widget primary v-button-primary']")).click();


		
		
		driver.close();
		driver.quit();
	}


}
