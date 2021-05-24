package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirstSeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	  System.setProperty("webdriver.chrome.driver", "C:\\ExternalJars\\chromedriver.exe");
    	  ChromeOptions options = new ChromeOptions();
    	  options.setHeadless(true);
    	  
		  WebDriver driver = new ChromeDriver(options);
		 
		  //driver.get("http://jenkins.bajpai.edu:8888/sampleapp/");
		  driver.get("https://egov.uscis.gov/casestatus/landing.do");
		  System.out.println(driver.getTitle());
		 
		/*
		 * try { driver.wait(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */driver.quit();
	}

}
