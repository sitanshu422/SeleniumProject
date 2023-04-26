import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownMenu {

	public static void main(String[] args) {
		//Selenium-server-4.1.2.jar file is used 
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Drop-down menu\\Drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		String Url = "https://mail.rediff.com/cgi-bin/login.cgi";
	    
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Create a new account")).click();
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("kamal");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("kamal1234");
		driver.findElement(By.className("btn_checkavail")).click();
		driver.findElement(By.id("radio_login")).click();
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys("Kamal@1234");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).click();
		WebElement Da = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
		Select Day = new Select(Da);
		Day.selectByIndex(20);
		WebElement Mon = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		Select Month = new Select(Mon);
		Month.selectByIndex(6);
		Select Year = new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")));
		Year.selectByVisibleText("2000");
		Select cont = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
		List<WebElement> lst =  cont.getOptions();
		for(int i=0; i<lst.size(); i++) {
			String B = lst.get(i).getText();
			System.out.println(B);
		}
		System.out.println("The number of countries in the dropdown: "+ lst.size());
		Select Country = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
		Country.selectByVisibleText("India");
		String CountryName = cont.getFirstSelectedOption().getText();
		System.out.println("Selected country is : " + CountryName);
		String Text = "India";
		if(Text.matches(CountryName)) {
			System.out.println("Expected text correct");
		}else {
			System.out.println("Expected text is not correct");
		}
		driver.quit();
		

	}

}
