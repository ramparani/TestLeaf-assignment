package week2.day2;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextNamePrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//find the name next to Home page
		
		WebElement lastText = driver.findElementByXPath("//a[text()='Go to Home Page']/following-sibling::label");
		System.out.println(lastText.getText());
		
		driver.close();
		
	}

}
