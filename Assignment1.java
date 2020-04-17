package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*1. Launch the ServiceNow application URL: https://dev92474.service-now.com/	
 2. Login with valid credentials username as admin and password as India@123	
 3. Enter Incident in filter navigator and press enter	
 4. Click on Create new option Under Incident	
 5. Get the text of Number Field and Store it in a String
 6. Click on the Search Button Available in the Caller Field & Choose First Value Opened in the new Window
 7. Select the Value as Software in Category Field
 8. Select Internal Application in Sub Category Field
 9. Select Walk-in in Contact Type Field
10. Select state as In-Progress 
11. Select Urgency as High 
12. Click on the Search Button Available in the Assignment Group & Choose Last Residing Value Opened in new Window
13. Enter Short Description as "Creating Incident For the Purpose of Management"
14. Click on the Submit Button
15. Enter The Incident Number Newly created in Search Field and Press Enter
16. Click on the newly Created Incident Displayed
17. Verify the Incident Number
18. Update Impact as High
19. Update Description as "Successfully Created an incident"
20. Enter Work Notes as "Done Right"
21. Click on the Update button.
22. Logout and Close

URL: https://dev92474.service-now.com/
Username: admin
Password: India@123*/

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Set the system property
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev92474.service-now.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();

		//Out of frame
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		//3.Enter the incident

		driver.findElementById("filter").sendKeys("Incident");

		//Enter key
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(3000);

		//4.Click create view under incident
		driver.findElementByLinkText("Create New").click();

		//5.Get the txt of number fiels and store it in a string
		driver.switchTo().frame("gsft_main");
		Thread.sleep(3000);
		String incNumber = driver.findElementById("incident.number").getAttribute("value");
		System.out.println("New Incident Number: "+incNumber);

		//6.Click on search button in caller field
		driver.findElementById("lookup.incident.caller_id").click();

		//switch to second Window
		Set<String> secWin = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(secWin);
		String win = lst.get(1);
		driver.switchTo().window(win);
		driver.findElementByClassName("glide_ref_item_link").click();

		//back to parent window
		String fwin = lst.get(0);
		driver.switchTo().window(fwin);
		System.out.println(driver.getTitle());
		
		
		Thread.sleep(3000);
		
		// 7. Select the Value as Software in Category Field
		
		WebElement category = driver.findElementById("incident.category");
		Select dd = new Select(category);
		dd.selectByValue("software");

		//8. Select Internal Application in Sub Category Field
		WebElement subcategory = driver.findElementById("incident.subcategory");
		Select subCat= new Select(subcategory);
		subCat.selectByValue("email");

		// 9. Select Walk-in in Contact Type Fi
		WebElement contactType = driver.findElementById("incident.contact_type");
		Select conType = new Select(contactType);
		conType.selectByVisibleText("Walk-in");

		//10. Select state as In-Progress 
		WebElement state = driver.findElementById("incident.state");
		Select s = new Select(state);
		s.selectByValue("In-Progress");

		//11. Select Urgency as High 

		WebElement urgency = driver.findElementById("incident.urgency");
		Select u = new Select(urgency);
		u.selectByValue("1");

		//12. Click on the Search Button Available in the Assignment Group & Choose Last Residing Value Opened in new Window
		driver.findElementById("lookup.incident.assignment_group").click();

		//Switch to new window
		Set<String> sw = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(sw);
		String swcWinRef = list1.get(1);
		driver.switchTo().window(swcWinRef);

		//list of items
		List<WebElement> group = driver.findElementsByClassName("glide_ref_item_link");
		
		// last item
		WebElement assignmentgroup = group.get(group.size()-1);
		assignmentgroup.click();
		
		//Parent Window
		String fisWin = list1.get(0);
		driver.switchTo().window(fisWin);
		
		//13. Enter Short Description as "Creating Incident For the Purpose of Management"
		driver.findElementById("incident.short_description").sendKeys("Creating Incident for the Purpose of Management");
		
		//14. Click on the Submit Button
		driver.findElementById("sysverb_insert").click();
		
		//15. Enter The Incident Number Newly created in Search Field and Press Enter
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input)[1]").sendKeys(incNumber, Keys.ENTER);
		Thread.sleep(3000);	
		
		//16. Click on the newly Created Incident Displayed
		driver.findElementByClassName("linked formlink").click();
		Thread.sleep(3000);
		
		//17. Verify the Incident Number
		String verify = driver.findElementById("incident.number").getAttribute("value");
		if(incNumber.equals(verify)) {
			System.out.println("Incident Number is same");
		}
		
		//18. Update Impact as High
		WebElement impact = driver.findElementById("incident.impact");
		Select imp = new Select(impact);
		imp.selectByValue("1");
		
		//19. Update Description as "Successfully Created an incident"
		driver.findElementById("incident.description").sendKeys("Successfully created an Incident");
		
		//20. Enter Work Notes as "Done Right"
		driver.findElementById("activity-stream-textarea").sendKeys("Done Right");
		
		//21. Click on the Update button.
		driver.findElementById("sysverb_update").click();
		
		
		
		
		//22. Logout and Close
		//out of frame
		driver.switchTo().defaultContent();
		driver.findElementByXPath("//span[text()='System Administrator']").click();
		
		driver.findElementByXPath("//a[text()='Logout']").click();
		
		// Close the browser
		driver.close();

		
	}

}
