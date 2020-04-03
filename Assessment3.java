package week1.day5;

import org.openqa.selenium.chrome.ChromeDriver;

public class Assessment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//setup chromedriver
				System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				
		    //launch site
			driver.get("https://www.amazon.in/");
			//search box
			driver.findElementById("twotabsearchtextbox").sendKeys("Harry Potter books");
			driver.findElementByClassName("nav-input").click();
			//rating
			//Since Books are unavailable so printed rating
			System.out.println("Rating:"+driver.findElementByLinkText("12,461").getText());
			//authour name
			System.out.println("Authour:"+driver.findElementByLinkText("J.K. Rowling").getText());
			//price
			
			
	}

}
