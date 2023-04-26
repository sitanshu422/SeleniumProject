package Pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import Base.Base;

public class TripCost extends Base{
	By search = By.xpath("(//input[@aria-label='Search'])[2]");
	By nairobi = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/a[4]/div[2]/div[2]/div[1]");
	By holiday = By.xpath("//span[text()='Holiday Homes']");
	By checkin = By.xpath("//button[@aria-label='Enter the date range.']");
	By date1 = By.xpath("//div[@aria-label='27 April 2023']");
	By date2 = By.xpath("//div[@aria-label='30 April 2023']");
	By guests = By.xpath("//div[@class='yzRfM f']//div[1]//*[name()='svg']");
	By plus = By.xpath("//div[@class='XVSGk f u Wg WUkfk']//button[@title='increase']//*[name()='svg']");
	By apply = By.xpath("//span[normalize-space()='Apply']");
	By sort = By.xpath("//span[text()='Tripadvisor Sort']");
	By traveler = By.xpath("//span[text()='Traveller Rating']");
	By word = By.xpath("//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[1]/div[1]/div/div/div[6]/div[1]");
	By more = By.xpath("(//div[contains(text(),'Show all')])[1]");
	By more1 = By.xpath("//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[1]/div[1]/div/div/div[9]/div[6]/span[1]");
	By more2 = By.xpath("//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[1]/div[1]/div/div/div[10]/div[6]/span[1]");
	By elevator = By.xpath("(//div[@class='hTbJa H o'])[27]");
	By name = By.xpath("//h2[@class='ToVyw b S7 W o q']");
	By price = By.xpath("//div[@class='iCUJC b']");
	By total = By.xpath("//div[@class='MvXmI']");
	By cruise = By.xpath("//span[text()='Cruises']");
	By line = By.xpath("//span[normalize-space()='Cruise line']");
	By line1 = By.xpath("//span[contains(text(),'Abercrombie & Kent')]");
	By search1 = By.xpath("//button[text()='Search']");
	By lang = By.xpath("//*[@id=\"ship_reviews\"]/div/div[2]/div/div[1]/div[1]/div[3]/ul/li");
	By passcrew = By.xpath("//div[contains(@class,'szsLm')]//div[1]");
	By launch = By.xpath("//div[contains(@class,'szsLm')]//div[3]");
	
	public void displayHotels() throws InterruptedException {
		logger = report.createTest("Diplay hotels in Nairobi.");
		openURL("websiteURLKey");
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(search));
		Thread.sleep(3000);
		driver.findElement(search).sendKeys(prop.getProperty("place"));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nairobi));
		driver.findElement(nairobi).click();
		Thread.sleep(5000);

		driver.findElement(holiday).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sort));
		driver.findElement(sort).click();
		driver.findElement(traveler).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		
		driver.findElement(more).click();
		Thread.sleep(3000);
		//driver.switchTo().frame("google_ads_top_frame");
		driver.findElement(elevator).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Apply']")).click();
		
		Thread.sleep(3000);
		driver.findElement(checkin).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(date1));
		Thread.sleep(2000);
		driver.findElement(date1).click();
		Thread.sleep(2000);
		driver.findElement(date2).click();
		Thread.sleep(4000);
		driver.findElement(guests).click();
		Thread.sleep(3000);
		driver.findElement(plus).click();
		Thread.sleep(1000);
		driver.findElement(plus).click();
		Thread.sleep(1000);
		driver.findElement(apply).click();
		System.out.println("The Homestays are: ");
		Thread.sleep(5000);
		System.out.println("All Hotels List are--------------");
		
		Thread.sleep(5000);
	
		List<WebElement> prices = driver.findElements(price);
		
		List<WebElement> names = driver.findElements(name);
		List<WebElement> totals = driver.findElements(total);
		for (int i = 0; i <5; i++) {
			System.out.println(names.get(i).getText() + " - "
					+ prices.get(i).getText()+ "per night  - "
							+ totals.get(i).getText());
			Thread.sleep(3000);
		} 
		Thread.sleep(3000);
		JavascriptExecutor jsw = (JavascriptExecutor) driver;
	      jsw.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		JavascriptExecutor jss = (JavascriptExecutor) driver;
	     jss.executeScript("window.scrollBy(0,-250)", "");
		reportPass("Name and Prices of the Hotels are Obtained");
		
	}
	
	public void cruises() throws InterruptedException, IOException {
		logger = report.createTest("Display languages and passengers crew.");
	
		driver.findElement(cruise).click();
		Thread.sleep(3000);
		driver.findElement(line).click();
		Thread.sleep(2000);
		driver.findElement(line1).click();
		Thread.sleep(2000);
		String currentHandle= driver.getWindowHandle();
		driver.findElement(search1).click();
		Set<String> handle1=driver.getWindowHandles();
		for(String actual: handle1) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
			}
		}
		TakesScreenshot capture = (TakesScreenshot) driver;
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")
				+ "/Screenshot/Cruises.png");
		Files.copy(srcFile, destFile);
		List<WebElement> langs = driver.findElements(lang);
		System.out.println("The languages are: ");
		for (int i = 1; i <langs.size(); i++) {
			System.out.println(langs.get(i).getText());
		}
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passcrew));
		String pass=driver.findElement(passcrew).getText();
		String launched=driver.findElement(launch).getText();
		System.out.println(pass);
		System.out.println(launched);
		
		
		reportPass("All languages and passengers,crews, launched date are Obtained Successfully");
	}
}
