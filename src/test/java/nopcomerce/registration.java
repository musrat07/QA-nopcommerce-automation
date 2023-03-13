package nopcomerce;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class registration {

	public static void main(String[] args) throws IOException {

		//Report for Registrations
		ExtentReports extent = new ExtentReports();
		File file = new File("registrationreports.html");
		ExtentSparkReporter registrationReport = new ExtentSparkReporter(file);
		extent.attachReporter(registrationReport);

		ExtentTest test1 = extent.createTest("Test 1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://training.nop-station.com/");	
		test1.pass("This is passed");
		ExtentTest test2 = extent.createTest("Test 2");
		//Maximize current window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
		test2.pass("This is passed");
		ExtentTest test3 = extent.createTest("Test 3");
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[2]/input")).sendKeys("Musrat");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[3]/input")).sendKeys("Jahan");
		Select drpDay = new Select(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")));
		drpDay.selectByValue("10");
		Select drpMonth = new Select(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]")));
		drpMonth.selectByValue("5");

		Select drpYear = new Select(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]")));
		drpYear.selectByValue("1997");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[5]/input")).sendKeys("musrat.prochito@gmail.com");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/div[2]/div/input")).sendKeys("SS Company");
		driver.findElement(By.id("Newsletter")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[4]/div[2]/div[1]/input")).sendKeys("pass@1234");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[4]/div[2]/div[2]/input")).sendKeys("pass@1234");		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[5]/button")).click();
		test3.pass("This is passed");
		extent.flush();
		Desktop.getDesktop().browse(new File("registrationreports.html").toURI());

	}

}
