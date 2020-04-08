package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//find the tagname
		
		List<WebElement> links = driver.findElementsByTagName("a");
		 System.out.println(links.size());
		links.get(0).click();
		System.out.println(driver.getTitle());
		driver.close();
		// driver.findElementByXPath("//a[text()='Go to Home Page']").click();
		// driver.navigate().back();
		// driver.findElementByXPath("(//a[text()='Go to Home Page'])[last()]").click();
		// driver.navigate().back();
		// List<WebElement> cli = driver.findElementsByLinkText("Go to Home Page");
		 //System.out.println(cli.size());
		 //cli.get(cli.size()-1).click();
		// WebElement value = driver.findElementByXPath("(//a[text()='Go to Home Page'])[last()]/following::label");
		 //System.out.println(value.getText());
		 
		 //System.out.println(driver.findElementByXPath("//label[@for='position']").getText());
		
	}

}
