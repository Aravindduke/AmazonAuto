package org.amz;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginTask {
public static void main(String[] args) throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path +"\\div\\chromedriver.exe");
	
	    WebDriver driver=new ChromeDriver();
	    
	    driver.get("https://www.amazon.in/");
	    driver.manage().window().maximize();
		
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone 12");
	    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	    List<WebElement> iphones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	    iphones.get(0).click();
	    Thread.sleep(5000);
	    String parentwindow = driver.getWindowHandle();
	   Set<String> allwindow = driver.getWindowHandles();
	   for(String x:allwindow) {
		   if(!x.equals(parentwindow)) {
			   driver.switchTo().window(x);
		   }
	   }
	 
	    WebElement addToCart = driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
	    addToCart.click();
	    
	
	    

}
}