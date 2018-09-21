package com.dumiduh.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Draggable {
	
	private WebDriver driver;
	
	//object references
	By firstBox = By.id("draggable");
	
	public By getFirstBox() {
		return firstBox;
	}

	public Draggable(WebDriver d) {
		this.driver = d;
	}
	
	public void goToURL() {
		driver.get("http://demoqa.com/draggable/");
	}
}

