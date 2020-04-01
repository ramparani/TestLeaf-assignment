package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FBLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		 
		
		//setup chromedriver
			ChromeDriver driver = new ChromeDriver(options);	
	    //launch site
		driver.get("https://www.facebook.com/");
		//get Title
		System.out.println(driver.getTitle());
		//Enter username
		driver.findElementById("email").sendKeys("xxx.com");
		//Enter password
		driver.findElementById("pass").sendKeys("xxx");
		//click on login
		driver.findElementById("loginbutton").click();
		//click logout
		driver.findElementById("userNavigationLabel").click();
		Thread.sleep(2000);
		driver.findElementByPartialLinkText("Log Out").click();
	}

}
