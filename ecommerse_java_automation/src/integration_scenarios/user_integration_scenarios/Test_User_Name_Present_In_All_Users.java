package integration_scenarios.user_integration_scenarios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_scripts.AutomationConstants;
import excel_automation.O3_ReadFromExcel;
import screenshots.TakeScreenshot;

public class Test_User_Name_Present_In_All_Users implements AutomationConstants {

	public static void main(String[] args) 
	{
			WebDriver driver=null;
			try
			{
				driver=new ChromeDriver();
				driver.get(urlOfHomepage);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				
				
				WebElement emailField =driver.findElement(By.xpath("//input[@type='email']"));
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				 String Emails = O3_ReadFromExcel.getData("Sheet2", 0, 0);
				emailField.sendKeys(Emails);
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				WebElement  passwordField=driver.findElement(By.xpath("//input[@type='password']"));
				String Password = O3_ReadFromExcel.getData("Sheet2", 0, 1);
				passwordField.sendKeys(Password);
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement loginlink=driver.findElement(By.xpath("//button[@type='submit']"));
				loginlink.click();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				alert.accept();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				String expectedTitle = "SuperAdmin Dashboard | ECODERS";
			    String actualTitle=driver.getTitle(); 
			    System.out.println("Actual Dashboard title is " + actualTitle);
			    
			    WebElement nameText = driver.findElement(By.xpath("//div[@class='relative']/button"));
			    System.out.println("name  dispalyed in dashboard"+nameText.getText());
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				try {
					
				    wait.until(ExpectedConditions.titleIs(expectedTitle));
				    System.out.println("Test case passed, Title matched");
				    
				   // driver.navigate().to("http://localhost:5173/about-us");
				    
				    // find the about us link, from header. 
				    WebElement totalCard = driver.findElement(By.xpath("//div[@class=\"grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6\"]/div[1]/div/div[1]"));
				    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				    totalCard.click();
				    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				    Thread.sleep(2000);
				    
				    
				    
				    
				    
				    String expectedAboutTitle = "All Users | ECODERS";
				    
				    String actualPageTitle = driver.getTitle();
				    System.out.println("Actual title of page is " + actualPageTitle);
				    
				    //String userNameList="shilpa";
				    String NameList = O3_ReadFromExcel.getData("Sheet2",1, 2);
					System.out.println("name present in excel   :"+NameList);
				    try {
				    	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[text()='nshilpanmurthy@gmail.com']/../h3"), NameList));
						System.out.println("text is present");
						Thread.sleep(1000);
				    	
				    }
				    catch(Exception e) 
				    {
				    	System.out.println("Test failed: text did not match. Screenshot captured.");
					    TakeScreenshot.getScreenshot(driver);
					    System.out.println("Testcase failed screenshot stored.");
				    	
				    }
				    
				    try
				    {
				    	wait.until(ExpectedConditions.titleIs(expectedAboutTitle));
					    System.out.println("Test case passed, Title matched");
				    }
				    catch(Exception ex)
				    {
				    	System.out.println("Test failed: Expected Title did not match. Screenshot captured.");
					    TakeScreenshot.getScreenshot(driver);
					    System.out.println("Testcase failed screenshot stored.");
				    }
				    
				    
				}
				catch (Exception ex) {
				    // Clean handling — no stack trace
				    System.out.println("Test failed: Expected Title did not match. Screenshot captured.");
				    TakeScreenshot.getScreenshot(driver);
				    System.out.println("Testcase failed screenshot stored.");
				    
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				driver.quit();
			}

		}
}
