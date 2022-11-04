package irisvision_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Welcome {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
		driver.manage().window().maximize();

        driver.get("https://dvc-staging.irisvision.com/welcome");
        
        
        //----------------------Check for Welcome page links-----------------------//
        
        Thread.sleep(2000);

        //Patients>> View Patients link     
        
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div[1]/div/button/span[1]")).click();
        Thread.sleep(2000);  
        String Patient_List_Page_URL = "https://dvc-staging.irisvision.com/patient/list";
        
        //To Check if the link verified or not
        
        if (driver.getCurrentUrl().equals(Patient_List_Page_URL)) {
        	System.out.println("View Patients Link Verified");
        }
        else
        	System.out.println("View Patients Link not Verified");
        Thread.sleep(2000);
        
        //Navigate to browser previous page by back button
        
        driver.navigate().back();
        Thread.sleep(3000);
        
        //Learn>> Explore link
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div[2]/div/button/span[1]")).click();
        Thread.sleep(2000);   
        String Learn_Page_URL = "https://dvc-staging.irisvision.com/learn";
        
        //To Check if the link verified or not
        if (driver.getCurrentUrl().equals(Learn_Page_URL)) {
        	System.out.println("Explore Link Verified");
        }
        else
        	System.out.println("Explore Link not Verified");
        Thread.sleep(2000);
        
        //Navigate to browser previous page by back button
        
        driver.navigate().back();
        Thread.sleep(2000);
        
        //Scroll Down to 
        Actions a = new Actions(driver);
        WebElement Contact_Us_Button_Link = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div[3]/div/button/span[1]"));
        a.moveToElement(Contact_Us_Button_Link).build().perform();
        
        //Sales Representative>> Contact Us Link
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div[3]/div/button/span[1]")).click();
        Thread.sleep(2000);          
       
        String Contact_Us_Page_URL = "https://dvc-staging.irisvision.com/contact-us";
        
        //To Check if the link verified or not
        if (driver.getCurrentUrl().equals(Contact_Us_Page_URL)) {
        	System.out.println("Contact Us Link Verified");
        }
        else
        	System.out.println("Contact Us Link not Verified");
        Thread.sleep(2000);
        
        //Navigate to browser previous page by back button
        
        driver.navigate().back();
        Thread.sleep(2000);
        
        
	}

}
