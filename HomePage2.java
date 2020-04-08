package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
//		1. Click on the last "Go to home page" link
		List<WebElement> eles = driver.findElementsByLinkText("Go to Home Page");
		System.out.println(eles.size());
		eles.get(eles.size()-1).click();

	}

}
