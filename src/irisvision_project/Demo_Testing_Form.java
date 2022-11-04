package irisvision_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Testing_Form {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Browser Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
		driver.manage().window().maximize();
		
		
		driver.get("https://demoqa.com/automation-practice-form/");
		
		
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Ammad");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Ali");
		Thread.sleep(1000);
		driver.findElement(By.id("userEmail")).sendKeys("ammadali@irisvision.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"gender-radio-1\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("userNumber")).sendKeys("3125156554");
		Thread.sleep(1000);
		
	}

}
