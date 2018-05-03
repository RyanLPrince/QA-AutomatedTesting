package com.qa.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoCompletePage {
	
	@FindBy(how=How.ID, using="tagss")
	private WebElement searchBox;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"ui-id-54\"]")
	private WebElement selection;
	
	public void search() throws InterruptedException {
		Thread.sleep(3000);
		searchBox.sendKeys("P");
	
	}

	public void autoSearch(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-menu-item")));
		
		List<WebElement>options= driver.findElements(By.className("ui-menu-item"));
		for (WebElement option:options) {
			if ("Python".equals(option.getText().trim())) {
				option.click();
				
			}
		}	
		
		
	}
	
}

