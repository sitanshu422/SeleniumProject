package com.selenium.basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.Test;

public class FirstJava {
	
	
		

		@Test
		public void verifyfacebookHomePage() {
			
			String URL = "https://www.facebook.com";
			
			//Open the URL with Selenium
			// We need to create an object of Webdriver, Webdriver is an interface
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Firstseleniumproject\\Drivers\\chromedriver.exe");
			
			//WebDriver driver = new ChromeDriver();
			//driver.get(URL);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			ChromeDriver driver = new ChromeDriver(options);
			
			driver.get(URL);
			
			driver.manage().window().maximize();
			//options.addArguments("--remote-allow-origins=*");
			//Verify Homepage Title
			String pageTitle = driver.getTitle();
			System.out.println("Page title is :" +pageTitle);
			Assert.assertEquals(pageTitle, "Facebook – log in or sign up");
			
			driver.quit();
			
			
		
	}

}
