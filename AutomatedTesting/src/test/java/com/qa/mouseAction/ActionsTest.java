package com.qa.mouseAction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;

import com.qa.constants.Constants;
import com.qa.page.DraggablePage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

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
	
		
	}
	
	@Test
	public void draggablePageTest() throws InterruptedException {
		driver.findElement(By.id("menu-item-140")).click();
		DraggablePage page = PageFactory.initElements(driver, DraggablePage.class);
		page.drag(100,100,action);
		driver.close();
	}
	
	@Ignore
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
