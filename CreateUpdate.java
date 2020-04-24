package servicenow.assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CreateUpdate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev82063.service-now.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@2020");
		driver.findElementById("sysverb_login").click();

		//Out of frame
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		//3.Enter the incident

		driver.findElementById("filter").sendKeys("Change");

		
		Thread.sleep(3000);

		//4.Click create view under incident
		driver.findElementByLinkText("Create New").click();
		
		

		//5.Get the txt of number fiels and store it in a string
		driver.switchTo().frame("gsft_main");
		Thread.sleep(3000);
		
		//Click on Normal Change
		driver.findElementByLinkText("Normal: Changes without predefined plans require approval and/or CAB authorization.").click();
		
		//Store the CHange number
		String ChangeNumber = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println("New Incident Number: "+ChangeNumber);
		
		//ENter Short desc
		driver.findElementById("change_request.short_description").sendKeys("First Change reqeust");
		//ENter Desc
		driver.findElementById("change_request.description").sendKeys("Description");
		
		//Click on submit
		driver.findElementById("sysverb_insert_bottom").click();
		
		//Sending change number in search field
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input").sendKeys(ChangeNumber,Keys.ENTER);
		
		//CLick on the created number
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		
		// Verify the number
		
		Thread.sleep(3000);
		String changeVerify = driver.findElementById("change_request.number").getAttribute("value");
		if(ChangeNumber.equals(changeVerify)) {
			System.out.println("Change Number "+ChangeNumber+ " Is Verified");
		}
		
		
		// Update state to Assess
		WebElement updateState = driver.findElementById("change_request.state");
		
		Select assess = new Select(updateState);
		assess.selectByVisibleText("Assess");
		
		driver.findElementById("lookup.change_request.assigned_to").click();

		// Navigate to Sec window

		Set<String> mulWin = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(mulWin);
		String itil = lst.get(1);

		driver.switchTo().window(itil);

		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input[1]").sendKeys("ITIL", Keys.ENTER);
		Thread.sleep(3000);
		
		// frst value
		driver.findElementByClassName("glide_ref_item_link").click();
		Thread.sleep(3000);
		
		// back to parent window
		String mainWin = lst.get(0);
		driver.switchTo().window(mainWin);
		Thread.sleep(3000);
				
		// Click search icon of assignment group
		driver.findElementById("lookup.change_request.assignment_group").click();

		// Navigate to window

		Set<String> secwin = driver.getWindowHandles();
		List<String> last = new ArrayList<String>(secwin);
		String app = last.get(1);

		driver.switchTo().window(app);
						
		// Click first value
		driver.findElementByXPath("//a[text()='Application Development']").click();
		Thread.sleep(3000);
					
		// Navigate back to main window
		String main = lst.get(0);
		driver.switchTo().window(main);
		Thread.sleep(3000);
				
		// Click on update
		driver.findElementById("sysverb_update").click();
		// Close the browser
		driver.close();
		
		

	}

}
