package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartClassPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//Button[text()='✕']").click();

		WebElement Electronic = driver.findElementByXPath("//span[text()='TVs & Appliances']");
		
		//mouse hover
		
		Actions builder=new Actions(driver);
		builder.moveToElement(Electronic).perform();
		
		Thread.sleep(3000);
		driver.findElementByLinkText("LG").click();
		
		System.out.println(driver.findElementByXPath("//div[contains(text(),'LG All-in-One 80cm (32 inch)')]").getText());
	}

}
