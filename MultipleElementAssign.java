package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleElementAssign {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//click Homepage link
		List<WebElement> links = driver.findElementsByTagName("a");
		 System.out.println(links.size());
		links.get(0).click();
		System.out.println(driver.getTitle());
		//CLick Image
		driver.findElementByXPath("//img[@alt='Images']").click();
		//count of images
		List<WebElement> image = driver.findElementsByTagName("img");
		 System.out.println("Count of Images:"+image.size());
	//Click on Keyboard image
		 int count = image.size()-1;
		System.out.println(count);
		WebElement key = image.get(count);
		System.out.println(key.getAttribute("src"));
		Actions mouse = new Actions(driver);
	    mouse.moveToElement(key).click().perform();
	    
	   //find how many radio buttons
		driver.findElementByXPath("//h5[text()='Radio Button']/following-sibling::img").click();
		List<WebElement> radiocount = driver.findElementsByTagName("input");
		System.out.println("Count of Total Radio Buttons: " + radiocount.size());
		//to find the group
		//WebElement radiogroup = driver.findElementByXPath("//label[contains(text(),'Select your age group')]");
		//System.out.println("Total Radio Buttons: " + radiogroup.getSize());
		
	//to select all the check boxes
		driver.navigate().back();
		driver.findElementByXPath("//h5[text()='Checkbox']/following-sibling::img").click();
		List<WebElement> checkbox = driver.findElementsByTagName("input");
		for ( WebElement chkbox : checkbox ) {
		    if ( !chkbox.isSelected() ) {
		        chkbox.click();
		    }
		}
		System.out.println("All Check Box checked");
		
	}

}
