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
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishn\\eclipse-workspace\\AmazonTask\\div\\chromedriver.exe");
	
	    WebDriver driver=new ChromeDriver();
	    
	    driver.get("https://www.amazon.in/");
	    driver.manage().window().maximize();
	    WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
	    Actions ac=new Actions(driver);
	    ac.moveToElement(account).perform();
	    WebElement signin = driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]"));
	    signin.click();
	    WebElement username = driver.findElement(By.xpath("//input[@id='ap_email']"));
	    username.sendKeys("vishnu31595@gmail.com");
	    driver.findElement(By.xpath("//input[@id='continue']")).click();
	    driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("vishnu900323");
	    driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone 12");
	    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	    List<WebElement> iphones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	    iphones.get(0).click();
	    Thread.sleep(10000);
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