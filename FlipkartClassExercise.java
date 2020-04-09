package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartClassExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//Button[text()='✕']").click();

		WebElement Electronic = driver.findElementByXPath("//span[text()='Electronics']");
		
		//mouse hover
		
		Actions builder=new Actions(driver);
		builder.moveToElement(Electronic).perform();
		
		Thread.sleep(3000);
		driver.findElementByLinkText("Mi").click();
	}

}
