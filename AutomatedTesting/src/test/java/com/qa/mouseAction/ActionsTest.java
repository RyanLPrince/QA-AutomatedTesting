package com.qa.mouseAction;

import static org.junit.Assert.*;

import org.junit.Before;

import com.qa.constants.Constants;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	private Actions action;
	private WebDriver driver;
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_LOCATION);	
		driver=new ChromeDriver();
		action=new Actions(driver);
		driver.get("http://demoqa.com/");
		driver.manage().window().maximize();
		action=new Actions(driver);
	}
	
	@Test
	public void drag() throws InterruptedException {
		driver.findElement(By.id("menu-item-140")).click();
		WebElement source= driver.findElement(By.id("draggable"));
		Thread.sleep(3000);
		action.dragAndDropBy(source, 100,100).perform();
		Thread.sleep(10000);
		driver.close();
	}
}
