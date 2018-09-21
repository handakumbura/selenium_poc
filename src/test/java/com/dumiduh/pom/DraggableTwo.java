package com.dumiduh.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;

public class DraggableTwo {
	WebDriver d;
	
	public DraggableTwo(WebDriver driver) {
		this.d=driver;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(how=How.ID,using="dragbox1") 
	@CacheLookup
	WebElement dragBoxOne;
	
	
}
