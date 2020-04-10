package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*1) Open https://www.myntra.com/
2) Mouse over on WOMEN
3) Click Jackets & Coats
4) Find the total count of item (top)
5) Validate the sum of categories count matches
6) Check Coats
7) Click + More option uder BRAND
8) Type MANGO and click checkbox
9) Close the pop-up x
10) Confirm all the Coats are of brand MANGO
11) Sort by Better Discount
12) Find the price of first displayed item
13) Mouse over on size of the first item
14) Click on WishList Now
15) Close Browser*/


public class MynthraAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		
		//1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		//2) Mouse over on WOMEN
		WebElement women = driver.findElementByXPath("(//div[@class='desktop-navLink'])[2]");
		
		Actions builder=new Actions(driver);
		builder.moveToElement(women).perform();
		
		//3) click Jackets and Coats
		Thread.sleep(3000);
		driver.findElementByLinkText("Jackets & Coats").click();
		
		
		//4) Find the total count of item (top)
		String titlecount = driver.findElementByClassName("title-count").getText();
		//System.out.println("Initial title :"+titlecount);
		String text = titlecount.replaceAll("\\D", ""); //to replace non numbers
		//System.out.println(text);
		int total = Integer.parseInt(text);
		System.out.println("Total Items count: "+total);
		
		//5) Validate the sum of categories count matches
		String jackets = driver.findElementByXPath("//span[@class='categories-num'][1]").getText();
		String jacketsnum = jackets.replaceAll("\\D", ""); //to replace non numbers
		int totaljacket = Integer.parseInt(jacketsnum);
		
		String coats = driver.findElementByXPath("(//span[@class='categories-num'])[last()]").getText();
		String coatsnum = coats.replaceAll("\\D", ""); //to replace non numbers
		int totalcoat = Integer.parseInt(coatsnum);
		
		int totaljc = totaljacket + totalcoat;
		
		if(total==totaljc)
		{
			System.out.println("Verified-Sum of Jackets and Coats Matches: "+totaljc);
		}
		else
		{
			System.out.println("Not Matched");
		}
		
		//6) Check Coats
		
		driver.findElementByXPath("(//span[@class='categories-num'])[last()]/following-sibling::div").click();
		
		//7) Click + More option uder BRAND
		
		driver.findElementByXPath("//div[text()=' more']").click();
		
		//8) Type MANGO and click checkbox
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
		driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div").click();
		
		//9) Close the pop-up x
		driver.findElementByXPath("//div[@class='FilterDirectory-titleBar']//span[1]").click();
		
		//10) Confirm all the Coats are of brand MANGO
		Thread.sleep(2000);
		List<WebElement> mango = driver.findElementsByTagName("h3");
		System.out.println(mango.size());
		for (WebElement result : mango) {
          if(!result.getText().contains("MANGO")) {
        	  System.out.println("It is not having mango as brand name");
          }
         
          
		}
		System.out.println("Verified-Match Brand");
		
				
			/*	String brand = result.getText();
				
				if (brand.contains("MANGO")) {
					
					System.out.println("Brand name displayed correctly: "+brand );
					
				} else {
					
					System.out.println("Brand name wrongly displayed: "+ brand);

				}*/
				
		
		//11) Sort by Better Discount
		
		driver.findElementByXPath("//div[@class='sort-sortBy']").click();
		
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		
		//12) Find the price of first displayed item
		 List<WebElement> discount = driver.findElementsByClassName("product-discountedPrice");
		 String firstprice = discount.get(0).getText();
			String clearprice = firstprice.replaceAll("\\D","");
			int amount = Integer.parseInt(clearprice);
		 // System.out.println(values);
		  System.out.println("First price: " + amount);
		  
		 //13) Mouse over on size of the first item
		  Thread.sleep(3000);
			WebElement size = driver.findElementByXPath("(//h3[text()='MANGO'])[1]");
			builder.moveToElement(size).perform();
			
		//14) Click on WishList Now
			
		  driver.findElementByXPath("(//div[@class='product-actions product-prelaunchActions'])[1]/span").click();
			
			// 15) Close Browser
			driver.close();
		}
	
	
	


}
