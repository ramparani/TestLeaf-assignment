package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// 3.Get the table and store it as a webelement
		WebElement tabletext = driver.findElementById("table_id");
		//4.Find the number of rows based on its tag name and store it in a list
		List<WebElement> rownumber = tabletext.findElements(By.tagName("tr"));
		//5.Find the number of cols based on its tag name and store it in a list
		List<WebElement> colnumber = tabletext.findElements(By.tagName("td"));
		//6.Print the size of the rows
		int rowcount = rownumber.size();
		System.out.println(rowcount);
		
		//7.Print the size of the column
		int colcount = colnumber.size();
		System.out.println(colcount);
		
		//8. Get the progress value of 'Learn to interact with Elements' and store it in a variable
		WebElement secrow = rownumber.get(2);
		List<WebElement> colnumber1 = secrow.findElements(By.tagName("td"));
		WebElement firstcol = colnumber1.get(0);
		String colfirst = firstcol.getText();
		
		//9.Print the text of the variable
		System.out.println(colfirst);
		//10.Find the vital task for the least completed progress and check the box
		WebElement thirdrow = rownumber.get(3);
		List<WebElement> colnumber2 = thirdrow.findElements(By.tagName("td"));
		WebElement seccol = colnumber2.get(1);
		String value = seccol.getText();
		System.out.println("Min value: "+ value);		
		driver.findElementByXPath("(//input[@type='checkbox'])[3]").click();
		
		
		
		
		
	}

}
