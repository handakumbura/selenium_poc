package com.dumiduh.selenium4.selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunnerOne {
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\SOFTWARE\\chromedriver.exe");
	}

	
	@Test(dataProvider="loginData")
	public void loginTest(String pwd, String cci) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("https://compelloweb-main.azurewebsites.net/");
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
		driver.findElement(By.xpath("//input[1]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		driver.findElement(By.id("exampleInputEmail3")).sendKeys(cci+Keys.ENTER);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@ref='eBodyViewport']/div[1]/div[1]/div[@col-id='ClientID']")));
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.xpath("//div[@ref='eBodyViewport']/div[1]/div[1]/div[@col-id='ClientID']"))).build().perform();
		Thread.sleep(5000);
		
		
		driver.close();
	}
	
	@DataProvider(name="loginData")
	public Object[][] populate(){
		
		Object[][] data = new Object[2][2];
		
		data[0][0] = "pgh3005";
		data[0][1] = "cctest";
		data[1][0] = "admin";
		data[1][1] = "x99x";

		
		
		return data;
	}
}
