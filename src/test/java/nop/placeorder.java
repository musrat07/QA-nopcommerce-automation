package nop;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class placeorder {

public static void main(String[] args) throws IOException, InterruptedException {

	// Report PlaceOrder
	ExtentReports extentReports = new ExtentReports();
	File file = new File("placeorderReport.html");
	ExtentSparkReporter placeorderReport = new ExtentSparkReporter(file);
	extentReports.attachReporter(placeorderReport);
	
	ExtentTest Order1 = extentReports.createTest("Test 1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://training.nop-station.com/");
		Order1.pass("This is passed");
		
		ExtentTest Order2 = extentReports.createTest("Test 2");
	//Maximize current window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
	 //Instantiate Action
		 Actions actions = new Actions(driver);
	  // perform mouse hover 
	    	WebElement menuOption = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a"));
	  //Mouse hover menuOption'
	    	actions.moveToElement(menuOption).perform();
	    	Order2.pass("This is passed");
	    	
	    	ExtentTest Order3 = extentReports.createTest("Test 3");
	    	driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/ul/li[2]/a")).click();
	    	Order3.pass("This is passed");
	    	
	    	ExtentTest Order4 = extentReports.createTest("Test 4");
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("window.scrollBy(0,350)", "");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/h2/a")).click();
        	Order4.pass("This is passed");
        	
        	ExtentTest Order5 = extentReports.createTest("Test 5");
        	JavascriptExecutor productdetails = (JavascriptExecutor) driver;
        	productdetails.executeScript("window.scrollBy(0,350)", "");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[7]/div/input")).clear();
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[7]/div/input")).sendKeys("2");
        	Order5.pass("This is passed");
        	
        	ExtentTest Order6 = extentReports.createTest("Test 6");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[7]/div/button")).click();
        	Order6.pass("This is passed");
        	
        	ExtentTest Order7 = extentReports.createTest("Test 7");
        	driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a/span[1]")).click();
        	JavascriptExecutor jscart = (JavascriptExecutor) driver;
        	jscart.executeScript("window.scrollBy(0,350)", "");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[3]/input")).click();
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[4]/button")).click();
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
        	Order7.pass("This is passed");
        	
       // Billing Information 	
        	ExtentTest Order8 = extentReports.createTest("Test 8");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[1]/input")).sendKeys("Musrat");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[2]/input")).sendKeys("Jahan");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[3]/input")).sendKeys("kumkum.jahan07@gmail.com");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[4]/input")).sendKeys("SS Company");
        	Select drpCountry = new Select(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[5]/select")));
        	drpCountry.selectByVisibleText("Bangladesh");
        	Select drpState = new Select(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[6]/select")));
        	drpState.selectByVisibleText("ঢাকা");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[7]/input")).sendKeys("Dhaka");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[8]/input")).sendKeys("H-1,R-11,S-13,Uttara");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[10]/input")).sendKeys("1230");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[11]/input")).sendKeys("01645678905");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[4]")).click();
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[1]/div/div/ul/li[2]/div[1]/input")).click();
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();
            Thread.sleep(5000);

        	driver.findElement(By.id("paymentmethod_1")).click();
        	//driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/form/div/div/div/ul/li[2]/div/div[2]/input")).click();
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")).click();
        	Order8.pass("This is passed");

         // Card Information	
        	Thread.sleep(5000);
        	ExtentTest Order9 = extentReports.createTest("Test 9"); 	
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[2]/td[2]/input")).sendKeys("Musrat Jahan Kumkum");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[3]/td[2]/input")).sendKeys("3566000020000410");
        	Select drpdate = new Select(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[4]/td[2]/select[1]")));
        	drpdate.selectByValue("2");
        	Select ExpiredYr = new Select(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[4]/td[2]/select[2]")));
        	ExpiredYr.selectByValue("2026");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[5]/td[2]/input")).sendKeys("123");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")).click();
        	Order9.pass("This is passed");
        	Thread.sleep(5000);
        	ExtentTest Order10 = extentReports.createTest("Test 10"); 
        	JavascriptExecutor jsBilling = (JavascriptExecutor) driver;
        	jsBilling.executeScript("window.scrollBy(0,350)", "");
        	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/button")).click();
        	Order10.pass("This is passed");
        	
             Thread.sleep(500);

        	extentReports.flush();
        	Desktop.getDesktop().browse(new File("placeorderReport.html").toURI());
        	
        	
        	
}
}
