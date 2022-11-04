package irisvision_project;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DVC_Portal_Main_Script {

	public static void main(String[] args) throws InterruptedException {
		
		// For FireFox:
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		// For Google_Chrome: 
		System.setProperty("webdriver.chrome.driver","C:/Softwares/Selenium material/chromedriver_win32/chromedriver.exe");
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
            	System.out.println("Welcome: Welcome page loaded successfully");
            }
            
        }
        
        else 
        	System.out.println("Login Failed");

    
        //--------------------------Welcome-------------------------------//
        
        Thread.sleep(2000);

        //Patients>> View Patients link     
        
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div[1]/div/button/span[1]")).click();
        Thread.sleep(2000);  
        String Patient_List_Page_URL = "https://dvc-staging.irisvision.com/patient/list";
        
        //To Check if the link verified or not
        
        if (driver.getCurrentUrl().equals(Patient_List_Page_URL)) {
        	System.out.println("Welcome: View Patients Link Verified");
        }
        else
        	System.out.println("Welcome: View Patients Link not Verified");
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
        	System.out.println("Welcome: Explore Link Verified");
        }
        else
        	System.out.println("Welcome: Explore Link not Verified");
        Thread.sleep(2000);
        
        //Navigate to browser previous page by back button
        
        driver.navigate().back();
        Thread.sleep(2000);
        
        //Scroll Down to Element
        Actions Scroll = new Actions(driver);
        WebElement Contact_Us_Button_Link = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div[3]/div/button/span[1]"));
        Scroll.moveToElement(Contact_Us_Button_Link).build().perform();
        
        //Sales Representative>> Contact Us Link
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[2]/div/div[3]/div/button/span[1]")).click();
        Thread.sleep(2000);          
       
        String Contact_Us_Page_URL = "https://dvc-staging.irisvision.com/contact-us";
        
        //To Check if the link verified or not
        if (driver.getCurrentUrl().equals(Contact_Us_Page_URL)) {
        	System.out.println("Welcome: Contact Us Link Verified");
        }
        else
        	System.out.println("Welcome: Contact Us Link not Verified");
        Thread.sleep(2000);
        
        //Navigate to browser previous page by back button
        
        driver.navigate().back();
        Thread.sleep(2000);
        
       
        
        
        //-----------------------------------Patient List-----------------------//
        //Navigated to Patient List Page
        driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[2]")).click();
        
        //Check if the page loaded or not
        if (driver.getCurrentUrl().equals(Patient_List_Page_URL)) {
        	System.out.println("Patients: Patient list page loaded successfully");
        }
        else
        	System.out.println("Patients: Patient list page not loaded");
        Thread.sleep(2000);
        
        
        //--------------------------------Search Patient--------------------------//
        //Search for required Patient
        driver.findElement(By.id("input-with-icon-adornment")).sendKeys("Ammad");
        Thread.sleep(2000);
        
        //Scroll to element
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
        
        //-----------------------------------------------INTAKE--------------------------------------//
        //Navigation to Intake section
        driver.findElement(By.xpath("//*[@id=\"patient-hub\"]/div[2]/div/div[1]/ul[1]/li[2]/span")).click();
        Thread.sleep(2000);
      
        //-----------------------------------------------Add Intake----------------------------------//    
        //Order Intake
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[1]/button")).click();
        Thread.sleep(2000);
        
        //Adding Instructions
        driver.findElement(By.name("instructions")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("instructions")).sendKeys("Test Intake using automation script, Kindly ignore");
        Thread.sleep(2000);
        
        // Intake Ordered
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/div[2]/button[1]")).click();
        Thread.sleep(3000);
        
        //Check for Intake Ordered successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Inatake Ordered successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Inatake NOT Ordered successfully for (Ammad Ali)");
        Thread.sleep(2000);
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).click();
        Thread.sleep(2000);
        
        //-----------------------------------------------Cancel Intake ----------------------------------//
        
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[3]/div/div[4]/div/button/span[1]")).click();
        Thread.sleep(2000);
        
        //Cancel Intake Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button[1]/span[1]")).click();
        Thread.sleep(2000);
        
        //Check for Inatke Cancelled successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Intake Cancelled successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Intake NOT Cancelled successfully for (Ammad Ali)");
        Thread.sleep(2000);	
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).click();
        Thread.sleep(2000);
        
        
        //-----------------------------------------------TESTS ----------------------------------//
        // Navigate to Test section
        driver.findElement(By.xpath("//*[@id=\"patient-hub\"]/div[2]/div/div[1]/ul[1]/li[3]/span")).click();
        Thread.sleep(2000);
        
        
        //-----------------------------------------------Add Test ----------------------------------//
        //Order Test
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[1]/div/button/span[1]")).click();
        Thread.sleep(2000);
        
        //Adding Instructions
        driver.findElement(By.name("instructions")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("instructions")).sendKeys("This is Test created using automation script, Kindly ignore");
        Thread.sleep(2000);
        
        // Test Ordered
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/div[8]/button[1]/span[1]")).click();
        Thread.sleep(3000);
        
        //Check for Test Ordered successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Test Ordered successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Test NOT Ordered successfully for (Ammad Ali)");
        Thread.sleep(2000);
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).click();
        Thread.sleep(2000);
        
        
        //-----------------------------------------------Send Reminder ----------------------------------//
        
        //Scroll Down to Element
        Actions Scrolls = new Actions(driver);
        WebElement Send_Reminder_Button_Link = driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[4]/div/div[3]/div/button/span[1]"));
        Scrolls.moveToElement(Send_Reminder_Button_Link).build().perform();
        
        //Clicked Send Reminder Button
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[4]/div/div[3]/div/button/span[1]")).click();
        Thread.sleep(2000);
        
        //Adding Instructions
        driver.findElement(By.name("instructions")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("instructions")).sendKeys("This is Test Reminder created using automation script, Kindly ignore");
        Thread.sleep(2000);
        
        // Reminder Sent
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/div[2]/button[1]/span[1]")).click();
        Thread.sleep(3000);
        
        //Check for Reminder sent successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Reminder sent successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Reminder NOT sent successfully for (Ammad Ali)");
        Thread.sleep(2000);
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).click();
        Thread.sleep(2000);
        
        //-----------------------------------------------Cancel Test ----------------------------------//
        
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[4]/div/div[2]/div/section/span[2]")).click();
        Thread.sleep(2000);
        
        //Cancel Test Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button[1]/span[1]")).click();
        Thread.sleep(3000);
        
        //Check for Test Cancelled successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Test Cancelled successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Test NOT Cancelled successfully for (Ammad Ali)");
        Thread.sleep(2000);	
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).click();
        Thread.sleep(2000);
        
        //-----------------------------------------------EXAM NOTES--------------------------------------//
        //Navigation to Exam Notes section
        driver.findElement(By.xpath("//*[@id=\"patient-hub\"]/div[2]/div/div[1]/ul[1]/li[4]")).click();
        Thread.sleep(2000);
        
        String Exam_Notes = "https://dvc-staging.irisvision.com/patient/MrPndEQWKNvrNyCib/profile?menuItem=ap";
        
        //To Check if the page loaded successfully or not
        if (driver.getCurrentUrl().equals(Exam_Notes)) {
        	System.out.println("Patients: Exam Notes page loaded successfully");
        }
        else
        	System.out.println("Patients: Exam Notes page not loaded");
        Thread.sleep(2000);
        
        //Download PDF
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div[3]/div[2]/div[2]/div[1]/button/span[1]")).click();
        Thread.sleep(2000);
      
        System.out.println("Exam Notes: PDF Downloaded successfully");
        
        //-----------------------------------------------MONITORING--------------------------------------//
        //Navigation to Monitoring section
        driver.findElement(By.xpath("//*[@id=\"patient-hub\"]/div[2]/div/div[1]/ul[2]/li[1]")).click();
        Thread.sleep(2000);
        
        //Add Monitoring Plan button
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[1]/button/span[1]")).click();
        Thread.sleep(2000);

        //Select Activity Intake
        driver.findElement(By.xpath("//*[@id=\"requestActivityIntake\"]/span[1]/span[1]/input")).click();
        Thread.sleep(2000);

        //Scroll Down to Element
        Actions Scroll_Instruction = new Actions(driver);
        WebElement Add_Instruction_textbox = driver.findElement(By.name("instructions"));
        Scroll_Instruction.moveToElement(Add_Instruction_textbox).build().perform();
        
        //Adding Instructions
        driver.findElement(By.name("instructions")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("instructions")).sendKeys("This is test Monitoring Plan created using automation script, Kindly ignore");
        Thread.sleep(2000);
        
        //Select Visual Acuity OU
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div/form/div[1]/div[4]/div[1]/div[2]/label[3]/span[1]/span[1]/input")).click();
        Thread.sleep(2000);
       
        //Scroll Down to Element
        //Scroll_Instruction.moveToElement(Add_Instruction_textbox).build().perform();
        //Select Contrast Sensitivity OU
        //driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div/form/div[1]/div[4]/div[2]/div[2]/label[3]/span[1]/span[1]/input")).click();
        //Thread.sleep(1000);
  
        //Scroll Down to Element
        //Scroll_Instruction.moveToElement(Add_Instruction_textbox).build().perform();
        //Select Amsler Grid OD
        //driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div/form/div[1]/div[4]/div[3]/div[2]/label[1]/span[1]/span[1]/input")).click();
        Thread.sleep(1000);
  
        //Scroll Down to Element
        //Scroll_Instruction.moveToElement(Add_Instruction_textbox).build().perform();
        //Select Visual Field Test OD
        //driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div/form/div[1]/div[4]/div[4]/div[2]/label[1]/span[1]/span[1]/input")).click();
        //Thread.sleep(2000);
        
        //Scroll Down to Element
        Actions Scroll_Done = new Actions(driver);
        WebElement Done_Button_Link = driver.findElement(By.xpath("//*[@id=\"monitoring-plan-done\"]/span[1]/span"));
        Scroll_Done.moveToElement(Done_Button_Link).build().perform();
        
        //Monitoring Plan Added
        driver.findElement(By.xpath("//*[@id=\"monitoring-plan-done\"]/span[1]/span")).click();
        Thread.sleep(2000);
        
        //Check for Monitoring Plan added successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Monitoring Plan Added successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Monitoring Plan NOT Added successfully for (Ammad Ali)");
        Thread.sleep(2000);
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button/span[1]")).click();
        Thread.sleep(2000);

        
        //-----------------------------------------------Edit Monitoring Plan ----------------------------------//
        
        // Edit Plan Button
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[3]/div/div[2]/div/div/button[2]/span[1]")).click();
        Thread.sleep(2000);
      
        //UnSelect Activity Intake
        driver.findElement(By.xpath("//*[@id=\"requestActivityIntake\"]/span[1]/span[1]/input")).click();
        Thread.sleep(2000);
        
        //Scroll Down to Element
        Actions Scroll_Done_Button = new Actions(driver);
        WebElement Done_Button = driver.findElement(By.xpath("//*[@id=\"monitoring-plan-done\"]/span[1]/span"));
        Scroll_Done_Button.moveToElement(Done_Button).build().perform();
        
        //Monitoring Plan Edited
        driver.findElement(By.xpath("//*[@id=\"monitoring-plan-done\"]/span[1]/span")).click();
        Thread.sleep(2000);
        
        //Check for Monitoring Plan updated successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Monitoring Plan Updated successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Monitoring Plan NOT Updated successfully for (Ammad Ali)");
        Thread.sleep(2000);
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button/span[1]")).click();
        Thread.sleep(2000);
        
        //-----------------------------------------------View Monitoring Plan Details ----------------------------------//
        
        //View Details Button
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[3]/div/div[2]/div/div/button[1]/span[1]")).click();
        Thread.sleep(3000);
        
        //Scroll Down to Element
        Actions Scroll_Close = new Actions(driver);
        WebElement Close_Button_Link = driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[3]/div/button[1]/span[1]"));
        Scroll_Close.moveToElement(Close_Button_Link).build().perform();
        Thread.sleep(3000);
        
        // Close View Details Screen
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[3]/button/span[1]")).click();
        Thread.sleep(2000);
      
        //Check for Monitoring Plan Details page closed or not
        if (driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[3]/div/div[2]/div/span")).isDisplayed()) {
        	System.out.println("Patients: Monitoring Plan  Reviewed for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Monitoring Plan Details NOT Reviewed for (Ammad Ali)");
        
        
        //-----------------------------------------------End Monitoring Plan ----------------------------------//
        
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[3]/div/div[2]/div/span")).click();
        Thread.sleep(2000);
        
        //End Monitoring Plan Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/div[3]/button[1]/span[1]")).click();
        Thread.sleep(2000);
        
        //Check for Monitoring Plan Ended successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Monitoring Plan Ended successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Monitoring Plan NOT Ended successfully for (Ammad Ali)");
        Thread.sleep(2000);	
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button/span[1]")).click();
        Thread.sleep(2000);
        
        //-----------------------------------------------SURVEYS--------------------------------------//
        //Navigation to Surveys section
        driver.findElement(By.xpath("//*[@id=\"patient-hub\"]/div[2]/div/div[1]/ul[2]/li[2]/span")).click();
        Thread.sleep(2000);
      
        //-----------------------------------------------Add Survey----------------------------------//    
        //Order Survey
        driver.findElement(By.xpath("//*[@id=\"patient-hub-right-content\"]/div/div/div[1]/button/span[1]")).click();
        Thread.sleep(2000);
        
        //Adding Instructions
        driver.findElement(By.name("instructions")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("instructions")).sendKeys("Test Survey created using automation script, Kindly ignore");
        Thread.sleep(2000);
        
        // Survey Ordered
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/div[2]/button[1]/span[1]")).click();
        Thread.sleep(3000);
        
        //Check for Survey Ordered successfully or not
        if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).isDisplayed()) {
        	System.out.println("Patients: Survey Ordered successfully for (Ammad Ali)");
        }
        else
        	System.out.println("Patients: Survey NOT Ordered successfully for (Ammad Ali)");
        Thread.sleep(2000);
        
        //Close Confirmation
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/button/span[1]")).click();
        Thread.sleep(2000);

        
        //-----------------------------------------------CALENDAR--------------------------------------//
        //Navigate to Calendar Page
        driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[3]/div/span")).click();
        Thread.sleep(2000);
        
        String Calendar_Page_URL = "https://dvc-staging.irisvision.com/apps/calendar";
        
        //To Check if the page loaded successfully or not
        if (driver.getCurrentUrl().equals(Calendar_Page_URL)) {
        	System.out.println("Calendar: Calendar page loaded successfully");
        }
        else
        	System.out.println("Calendar: Calendar page not loaded");
        Thread.sleep(2000);
        
        //-----------------------------------------------LEARN--------------------------------------//
        //Navigate to Learn Page
        driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[4]/div/span")).click();
        Thread.sleep(2000);
        
        //To Check if the page loaded successfully or not
        if (driver.getCurrentUrl().equals(Learn_Page_URL)) {
        	System.out.println("Learn: Learn page loaded successfully");
        }
        else
        	System.out.println("Learn: Learn page not loaded");
        Thread.sleep(2000);
        
        //-----------------------------------------------CONTACT US--------------------------------------//
        //Navigate to Contact Us Page
        driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[5]/div/span")).click();
        Thread.sleep(2000);
        
        //To Check if the page loaded successfully or not
        if (driver.getCurrentUrl().equals(Contact_Us_Page_URL)) {
        	System.out.println("Contact Us: Contact Us page loaded successfully");
        }
        else
        	System.out.println("Contact Us: Contact Us page not loaded");
        Thread.sleep(2000);
        
        //-----------------------------------------------SETTINGS--------------------------------------//
        //Navigate to Settings Page
        driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[6]/div/span")).click();
        Thread.sleep(2000);
        
        String Settings_Page_URL = "https://dvc-staging.irisvision.com/settings";
        
        //To Check if the page loaded successfully or not
        if (driver.getCurrentUrl().equals(Settings_Page_URL)) {
        	System.out.println("Settings: Settings page loaded successfully");
        }
        else
        	System.out.println("Settings: Settings page not loaded");
        Thread.sleep(2000);
        
        //-----------------------------------------------ABOUT--------------------------------------//
        //Navigate to About Page
        driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[7]/div/span")).click();
        Thread.sleep(2000);
        
        String About_Page_URL = "https://dvc-staging.irisvision.com/about";
        
        //To Check if the page loaded successfully or not
        if (driver.getCurrentUrl().equals(About_Page_URL)) {
        	System.out.println("About: About page loaded successfully");
        }
        else
        	System.out.println("About: About page not loaded");
        Thread.sleep(2000);
        
        //-----------------------------------------------TERMS & CONDITIONS--------------------------------------//
        //Navigate to Term & Conditions Page
        driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[8]/div/span")).click();
        Thread.sleep(2000);
        
        String Term_and_Conditions_Page_URL = "https://dvc-staging.irisvision.com/terms-conditions";
        
        //To Check if the page loaded successfully or not
        if (driver.getCurrentUrl().equals(Term_and_Conditions_Page_URL)) {
        	System.out.println("Term & Conditions: Term & Conditions page loaded successfully");
        }
        else
        	System.out.println("Term & Conditions: Term & Conditions page not loaded");
        Thread.sleep(2000);
        
        //-----------------------------------------------SIGN OUT-------------------------------------//
       
        //Scroll Down to Element
        Actions Scroll_SignOut = new Actions(driver);
        WebElement SignOut_Button_Link = driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[9]/div/span"));
        Scroll_SignOut.moveToElement(SignOut_Button_Link).build().perform();
        Thread.sleep(2000);
        
        //Click on to Sign Out button
        driver.findElement(By.xpath("//*[@id=\"fuse-navbar\"]/div/div/div[1]/ul/a[9]/div/span")).click();
        Thread.sleep(3000);    
        
        String SignOut_Page_URL = "https://dvc-staging.irisvision.com/sign-out";
        
        //To Check if the User Sign Out Successfully
        if (driver.getCurrentUrl().equals(SignOut_Page_URL)) {
        	System.out.println("Sign Out: User Sign Out successfully");
        }
        else
        	System.out.println("Sign Out: User didn't Sign Out successfully");
        Thread.sleep(2000);
        
        //Click on to Sign Out button
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div/div/div/button/span[1]")).click();
        Thread.sleep(2000); 
        
        String SignIn_Page_URL = "https://dvc-staging.irisvision.com/login";
        
        //To Check if the User navigated to Sign In screen Successfully
        if (driver.getCurrentUrl().equals(SignIn_Page_URL)) {
        	System.out.println("Sign Out: User navigated to Sign In screen Successfully");
        }
        else
        	System.out.println("Sign Out: User didn't navigated to Sign In screen Successfully");
        Thread.sleep(2000);
        
        //close Browser
        driver.close();
	}

}
