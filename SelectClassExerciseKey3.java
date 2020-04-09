package week2.day4;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectClassExerciseKey3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//select
		WebElement item1 = driver.findElementByXPath("//ol[//@id='selectable']/li[1]");
		WebElement item4 = driver.findElementByXPath("//ol[//@id='selectable']/li[4]");
		
		
		 //to click and hold and then release on item 4
		Actions builder=new Actions(driver);
		builder.clickAndHold(item1).release(item4).perform();//if MAC then command

	}

}
