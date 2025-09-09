package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendkeys(WebElement elementname,String filepath)
	{
	elementname.sendKeys(filepath);
	}



public void fileUploadUsingRobotclass(WebElement elementname,String filepath) throws AWTException
	{
	StringSelection string=new StringSelection(filepath);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string,null);
	Robot robot=new Robot();
	robot.delay(2500);
	robot.keyPress(KeyEvent.VK_CONTROL);//KeyEvent class, VK-vertual key
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	}

}