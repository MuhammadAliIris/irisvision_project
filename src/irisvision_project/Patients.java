package irisvision_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Patients {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Browser Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
		driver.manage().window().maximize();

        driver.get("https://dvc-staging.irisvision.com/patient/list");
        
        
        //Check if the page loaded or not
        String Patient_List_Page_URL = "https://dvc-staging.irisvision.com/patient/list";
        if (driver.getCurrentUrl().equals(Patient_List_Page_URL)) {
        	System.out.println("Patients: Patient list page loaded successfully");
        }
        else
        	System.out.println("Patients: Patient list page not loaded");
        Thread.sleep(2000);
        
        
        //--------------------------------Add Patient----------------------------//
        
        WebElement Add_Patient_Button = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div/div[2]/button/span[1]"));
        Add_Patient_Button.click();
        Thread.sleep(2000);
        
        //Choosing Patient Product
        //driver.findElement(By.linkText(""));
        
        driver.findElement(By.name("firstName")).sendKeys("Ammad");
        driver.findElement(By.name("lastName")).sendKeys("Automation User 1");
        // DOB Selection
        //driver.findElement(By.name("dob")).click();
        driver.findElement(By.name("patientPhoneNumber")).sendKeys("3125156554");
        driver.findElement(By.name("patientEmail")).sendKeys("ammad@automationuser1.com");
        
        //driver.findElement(By.xpath("//*[@id=\"add-patient-wrapper\"]/div[5]/div/button[1]")).click();
        
        //--------------------------------Search Patient--------------------------//
        //Search for required Patient
        driver.findElement(By.id("input-with-icon-adornment")).sendKeys("Ammad");
        Thread.sleep(2000);
        
        //Scroll to element
        Actions Scroll = new Actions(driver);
        WebElement Patient_Ammad_Ali = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr[6]/td[1]/span"));
        Scroll.moveToElement(Patient_Ammad_Ali).build().perform();
        Thread.sleep(2000);
        
        //Check if the patient found or not
        if(Patient_Ammad_Ali.isDisplayed()) {
            System.out.println("Patients: Ammad Ali patient founded");
        } else {
            System.out.println("Patients: Patient not found");
        }
        
        //Selecting patient
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr[6]/td[1]/span")).click();
        Thread.sleep(2000);
        
        //Check if the correct patient profile is opened
        String AmmadAli_Profile_URL = "https://dvc-staging.irisvision.com/patient/MrPndEQWKNvrNyCib/profile";
        if (driver.getCurrentUrl().equals(AmmadAli_Profile_URL)) {
        	System.out.println("Patients: Patient profile page loaded successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Patient profile page NOT loaded successfully for (Ammad Ali)");
        Thread.sleep(2000);
        
        
        //-----------------------------------------------Add Appointment----------------------------------//
        //Click on Add Appointment
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[1]/button/span[1]")).click();
        Thread.sleep(2000);
        
        //Adding Instructions
      
        driver.findElement(By.id("notes")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("notes")).sendKeys("Test appointment using automation script, Kindly ignore");
        Thread.sleep(2000);
        
        //Appointment Added
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div/form/div[5]/button[1]/span[1]")).click();
        Thread.sleep(4000);
        
        //Check for Appointment Added successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Appointment added successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Appointment NOT added successfully for (Ammad Ali)");
        Thread.sleep(2000);
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).click();
        Thread.sleep(2000);
        
        //-----------------------------------------------Cancel Appointment----------------------------------//
      
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[3]/div/div[3]/div[2]/button/span[1]")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/div[4]/button[1]/span[1]")).click();
        Thread.sleep(3000);
        
        
      //Check for Appointment Cancelled successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button[2]/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Appointment Cancelled successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Appointment NOT Cancelled successfully for (Ammad Ali)");
        Thread.sleep(2000);	
        
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button[2]/span[1]")).click();
        Thread.sleep(2000);
        
	}

}
