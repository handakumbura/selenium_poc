package com.dumiduh.selenium.selenium3;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunnerOne {
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\SOFTWARE\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	}

	@Test(enabled = false)
	public void testcaseOne() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("http://store.demoqa.com/");
		
		WebElement elem = driver.findElement(By.cssSelector("input[name='s']"));
		elem.sendKeys("test123");
				
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("Product Category"))).build().perform();
		driver.findElement(By.linkText("iPads")).click();
		Thread.sleep(5000);
		
		driver.close();
	}
	
	@Test
	public void testcaseTwo() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("http://store.demoqa.com/");
				
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("Product Category"))).build().perform();
		driver.findElement(By.linkText("iPads")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[title='Grid View']")).click();
		Thread.sleep(2000);
		
		double sum = 0;
		for (WebElement e: driver.findElements(By.xpath("//span[@class='currentprice']"))) {
			String s = e.getText();
			String s2 = s.substring(1, s.length());			
			double d = Double.parseDouble(s2);
			sum = sum + d;
		};
		Assert.assertEquals(sum, 1100.00);
		System.out.println(sum);
		
		driver.close();
	}
}
