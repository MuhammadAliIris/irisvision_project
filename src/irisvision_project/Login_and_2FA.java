package irisvision_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_and_2FA {

public static void main(String[] args) throws InterruptedException {
		
		// For FireFox:
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		// For Google_Chrome: 
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Browser Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
		driver.manage().window().maximize();
		
        String baseUrl = "https://dvc-staging.irisvision.com/login";
        String expectedTitle = "IrisVision DVC Portal";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Login page Loaded successfully");
        } 
        else {
            System.out.println("Invalid URL");
        }
       
        
        // --------------Login---------------
        
        Thread.sleep(2000);
        
        
        //Scrolling down
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,4400)", "");
        //js.executeScript("arguments[0].scrollIntoView();", Contact_Us_Form);
        //Thread.sleep(5000);
        
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Username = driver.findElement(By.name("email"));
        Username.clear();
        Username.sendKeys("collin.munro@munro.org");
        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("Asdf@1234");
        
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div/div/div/form/button")).click();
        
        Thread.sleep(2000);
        
        String URL = driver.getCurrentUrl();
        String Welcome = "https://dvc-staging.irisvision.com/welcome";
        String TFA = "https://dvc-staging.irisvision.com/two-factor-auth";

        Thread.sleep(2000);
        
        //--------------Check for Login Successfully-------------//
        
        if (URL.equals(Welcome)); {
        	System.out.println("Login Successfully");
        	
        }
        

        //---------------------Check for 2FA---------------------//

        
        if (URL.equals(TFA)) {
        	
        	WebElement PhoneNumber = driver.findElement(By.name("phoneNumber"));
        	PhoneNumber.clear();
        	PhoneNumber.sendKeys("9999999999");
        	
        	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div/div/div/form/button")).click();
        	
        	Thread.sleep(2000);
        	
        	WebElement Verification_Code = driver.findElement(By.name("authCode"));
        	Verification_Code.clear();
        	Verification_Code.sendKeys("999999");
        
        	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div/div/div/form/button")).click();
        	
        	Thread.sleep(2000);
        	
        	//---------------------Check for 2FA Passed---------------------//
        	
        	if (URL.equals(Welcome)); {
            	System.out.println("2FA Passed Successfully");
            	
            }
            
        }
        
        else 
        	System.out.println("Login Failed");

	}

}
