package week3.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Sele4RelativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
		//Launch the browser
		/*driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 //2. if all the locators are not prioper then we use advanced xpath, but selenium 4 gave option by taking the reference of previous one and by using a methods.
	      //this is called as relative locators- it is one of the implemetation class with methods
	      	//-below(),above(),near(),toLeftOf(),toRightOf()
		//using relative locator
		WebElement rl = driver.findElement(RelativeLocator.withTagName("input").below(By.id("password")));  //inpsecting login by using the password which is above login
		rl.click();
		//below or any funtion will work the last one, to choose the immediate one then we should use near()
		driver.close();*/
		
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement r2 = driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.xpath("//ul[@class='wp-categories-list']/li[8]")).below(By.xpath("//ul[@class='wp-categories-list']/li[1]")));  //inpsecting login by using the password which is above login
		System.out.println(r2.getText());
		
		
	}
	
	

}
