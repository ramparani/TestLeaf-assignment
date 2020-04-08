package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		
		
		//setup chromedriver
			ChromeDriver driver = new ChromeDriver();	
	    //1.launch site
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//getting Title
		System.out.println(driver.getTitle());
		//Maximize the browser
		driver.manage().window().maximize();
		//2.Login
		//Entering username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Entering Password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click login
		driver.findElementByClassName("decorativeSubmit").click();
		//3.Click on CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		//4.Click on create lead
		driver.findElementByLinkText("Create Lead").click();
		//5.Enter Mandatory Fields
		driver.findElementById("createLeadForm_companyName").sendKeys("TW");
		driver.findElementById("createLeadForm_firstName").sendKeys("Ramparani");
		driver.findElementById("createLeadForm_lastName").sendKeys("J");
		//6.Choose the dropdown source using one of the text
WebElement dropsrc = driver.findElementById("createLeadForm_dataSourceId");
		
		//Convert the webelemet to Select
		//Select is a class
		
		Select dd1=new Select(dropsrc);
		
		//Interact with Drop down using menthod
		// 3 menthods
		//1. By text- balck in colour
		dd1.selectByVisibleText("Employee");
		//7. CHoose the industry dropdown the last one of the index
		
WebElement dropind = driver.findElementById("createLeadForm_industryEnumId");
		
		//Convert the webelemet to Select
		//Select is a class
Select dd2=new Select(dropind);
List<WebElement> options = dd2.getOptions();

//find the count of list item-size()
int count=options.size();

//Seletc the last
//SInce it is number so index method

dd2.selectByIndex(count-1);

//8.Onweship
WebElement dropown = driver.findElementByName("ownershipEnumId");
Select dd3=new Select(dropown);
dd3.selectByValue("OWN_LLC_LLP");
	}

}
