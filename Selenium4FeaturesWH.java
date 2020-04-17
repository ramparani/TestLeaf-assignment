package week3.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4FeaturesWH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//**************************************//
		//Features of Selenium 4//
		//1. Windows handles
		//in Selenium 4 -- this will open new window and switch control from one browser to anotehr browser
      driver.switchTo().newWindow(WindowType.WINDOW); //enum-windowtype 
      //if need to open new tab
      driver.switchTo().newWindow(WindowType.TAB); 
      driver.get("https://google.com/");
      
      
     	
      
      
	}

}
