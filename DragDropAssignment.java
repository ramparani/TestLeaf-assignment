package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Click Droppable
		driver.findElementByXPath("//img[@alt='drop']").click();
		//dragt and drop
		WebElement drag = driver.findElementById("draggable");
		WebElement drop = driver.findElementById("droppable");
		
		Actions builder=new Actions(driver);
		builder.dragAndDrop(drag, drop).perform();

	}

}
