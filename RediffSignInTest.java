package com.selenium.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RediffSignInTest {
	
	
	@Test
	public void testRediffSignIn() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Firstseleniumproject\\Drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		
		//Open the Rediff.com
		
		driver.get("https://www.rediff.com/");
		
		//verify the page title
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle,"Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		
		//click on SignIn button
		
		//WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]"));
		signInLink.click();
		
		//verify the signin page title
		
		Assert.assertEquals(driver.getTitle(),"Rediffmail");
		
		
		//Insert user name and password
		WebElement userName = driver.findElement(By.id("login1"));
		WebElement password = driver.findElement(By.name("passwd"));
		userName.sendKeys("Mishra@123");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password.sendKeys("test@123");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//click Submit button
		
		WebElement btn = driver.findElement(By.name("proceed"));
		btn.click();
		
		//verify profile title
		
		//Assert.assertEquals(driver.getTitle(),"Welcome to RediffMail");
		
		driver.quit();
		
		
	}

}
