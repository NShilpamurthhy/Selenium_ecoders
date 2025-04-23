package homepagescenarios_shilpa;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_scripts.AutomationConstants;
import excel_automation.O3_ReadFromExcel;


public class MultipleUsers implements AutomationConstants {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            for (int i = 0; i <= 25; i++) {
                driver.get(urlOfRegister);
                System.out.println("Register Page Title: " + driver.getTitle());

                // 1. Get data from Excel
                String name = O3_ReadFromExcel.getData("Sheet2", i, 2);
                String email = O3_ReadFromExcel.getData("Sheet2", i, 0);
                String password = O3_ReadFromExcel.getData("Sheet2", i, 1);

//                // 2. Fill registration form
//                driver.findElement(By.id("name")).sendKeys("raghu");
//                driver.findElement(By.id("email")).sendKeys("raghu@gmail.com");
//                driver.findElement(By.id("password")).sendKeys("Sharu@05!");

                // 2. Fill registration form
              driver.findElement(By.id("name")).sendKeys(name);
              driver.findElement(By.id("email")).sendKeys(email);
              driver.findElement(By.id("password")).sendKeys(password);

                
                
                
                // 3. Click Register
                driver.findElement(By.xpath("//button[@type='submit']")).click();

                // 4. Handle Alert (if any)
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                try {
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    System.out.println("Registration Alert: " + alert.getText());
                    alert.accept();
                } catch (Exception e) {
                    System.out.println("No alert after registration.");
                }

                // 5. Redirect to login page (assuming it redirects automatically or manually go)
                // Optionally you can manually go to login if not redirected
                //driver.get(urlOfLogin);

              
                driver.get(urlOfLogin);
                
               
				String email1 = O3_ReadFromExcel.getData("Sheet2", i, 0);
                String password1 = O3_ReadFromExcel.getData("Sheet2", i, 1);
                
                
                driver.findElement(By.id("email")).sendKeys(email1);
                System.out.println(email1);
                driver.findElement(By.id("password")).sendKeys(password1);
             
                driver.findElement(By.xpath("//button[text()='Login']")).click();


//                // 6. Fill login form with same email/password
//                driver.findElement(By.id("email")).sendKeys("raghu@gmail.com");
//                driver.findElement(By.id("password")).sendKeys("Sharu@05!");
//                driver.findElement(By.xpath("//button[text()='Login']")).click();

                
                
                
                // 7. Handle Alert after login (if any)
                try {
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert loginAlert = driver.switchTo().alert();
                    System.out.println("Login Alert: " + loginAlert.getText());
                    loginAlert.accept();
                } catch (Exception e) {
                    System.out.println("No alert after login.");
                }

           //      8. Confirm login status or capture error
                try {
                    WebElement errorMsg = driver.findElement(By.xpath("//p[@class='errorText mb-4']"));
                    System.out.println("Login Error: " + errorMsg.getText());
                } catch (Exception e) {
                    System.out.println("Logged in successfully or no error message found.");
                }

                System.out.println("Current URL: " + driver.getCurrentUrl());
                
                
            
       try {
            	//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
    	   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center gap-2 font-medium text-white']")));
        	element.click();
        	
        	Thread.sleep(4000);   
        	WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Lo')]")));
        	logout.click();
        	System.out.println( "actual title   "+driver.getTitle());
        	System.out.println("actual  url  "+driver.getCurrentUrl());
            }	
            
            catch(Exception e) {
            	e.printStackTrace();
            }
            
            
            }}
    
    catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		Thread.sleep(3000);
		driver.quit();
	}

    
    }
}