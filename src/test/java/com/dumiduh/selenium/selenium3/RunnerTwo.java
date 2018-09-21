package com.dumiduh.selenium.selenium3;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.CompositeAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dumiduh.pom.Draggable;

public class RunnerTwo {

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\SOFTWARE\\chromedriver.exe");
	}

	@Test(enabled=false)
	public void testcaseOne() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("https://compelloweb-main.azurewebsites.net/");
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
		driver.findElement(By.xpath("//input[1]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pgh3005");
		driver.findElement(By.id("exampleInputEmail3")).sendKeys("cctest"+Keys.ENTER);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@ref='eBodyViewport']/div[1]/div[1]/div[@col-id='ClientID']")));
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.xpath("//div[@ref='eBodyViewport']/div[1]/div[1]/div[@col-id='ClientID']"))).build().perform();
		Thread.sleep(5000);
		
		
		driver.close();
	}
	
	@Test(enabled=false)
	public void testcaseTwo(){
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.findElement(By.id("button1")).click();
		Object[] o = driver.getWindowHandles().toArray();
		/*String[] ar = new String[s.size()];
		//System.out.println("before loop"+driver.getWindowHandles());*/
		for(Object o2 : o) {
			String v = (String) o2;
			if(!v.equals(driver.getWindowHandle())) {
				driver.switchTo().window(v);
			}
		}
		driver.manage().window().maximize(); 
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='menu-text'][1]")));
		System.out.println(driver.findElement(By.xpath("//span[@class='menu-text'][1]")).getText());
		
		
		//driver.switchTo().window();
		driver.close();
	}
	
	@Test(enabled=false)
	public void testcaseThree() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.presenceOfElementLocated(By.name("iframe1")));
		driver.switchTo().frame(driver.findElement(By.name("iframe1")));
		String s = driver.findElement(By.xpath("//a[@title='Automation Practice Form'][1]/strong")).getText();
		System.out.println(s);
		driver.switchTo().parentFrame();
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void testcaseFour() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Draggable dragable = new Draggable(driver);
		dragable.goToURL();
		
		
		WebElement e = driver.findElement(dragable.getFirstBox());
		
		CompositeAction ca = new CompositeAction();
		Actions a = new Actions(driver);
		a.pause(Duration.ofSeconds(5, 0));
		a.dragAndDropBy(e, 100, 100).build();
		ca.addAction(a.dragAndDropBy(e, 100, 100).build());
		ca.addAction(a.dragAndDropBy(e, 100, 200).build());
		ca.addAction(a.dragAndDropBy(e, -100, 200).build());
		
		ca.perform();
		
		driver.findElement(By.linkText("Cursor style")).click();
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='drag']/p")));
		System.out.println(driver.findElement(By.xpath("//*[@id='drag']/p")).getText());
		WebElement e2 = driver.findElement(By.xpath("//*[@id='drag']/p"));
		Point p = driver.findElement(By.xpath("//*[@id=\"drag2\"]/p")).getLocation();
		
		Actions a2 = new Actions(driver);
		a2.dragAndDropBy(e2, p.x, p.y).build().perform();
		
		driver.findElement(By.linkText("Draggable + Sortable")).click();
		WebElement w2 = driver.findElement(By.id("draggablebox"));
		
		Point p2 = driver.findElement(By.xpath("//ul[@class='ui-sortable']/li[2]")).getLocation();
	
		a2.dragAndDrop(w2, driver.findElement(By.xpath("//ul[@class='ui-sortable']/li[2]")));
		a.pause(Duration.ofSeconds(5, 0));
	}
}
