package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DraggablePage {
	
	@FindBy(how=How.ID,using="draggable")
	private  WebElement box;
	
	public void drag(int x, int y, Actions action) throws InterruptedException {
		Thread.sleep(3000);
		action.dragAndDropBy(box, x,y).perform();
		Thread.sleep(10000);
		
	}
	
}
