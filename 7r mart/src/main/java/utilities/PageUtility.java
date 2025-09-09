package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectByVisibleText(WebElement element,String visibleText) 
	{
	Select select =new Select(element);
	select.selectByVisibleText(visibleText);;
	}

public void selectByValue(WebElement element,String value) 
	{
	Select select =new Select(element);
	select.selectByValue(value);;;
	}

public void selectByIndex(WebElement element, int index) 
	{
    Select select = new Select(element);
    select.selectByIndex(index);
	}

public void javaScriptClick(WebDriver driver, WebElement webElementName)
	{			
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", webElementName); //arguments[0].click() represent the script to click the button element
	}

public void javaScriptSendText(WebDriver driver, WebElement webElementName)
	{		
	JavascriptExecutor js = (JavascriptExecutor) driver; //typecast the driver to JavascriptExecutor
	js.executeScript("arguments[0].value='Hello';", webElementName);
	}

public void javaScriptScrollToBottom(WebDriver driver)
	{
	JavascriptExecutor js = (JavascriptExecutor) driver; //typecast the driver to JavascriptExecutor
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}


}