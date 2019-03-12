package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	
	protected WebDriver driver;
	
	// create constructor 
		public PageBase(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
		
	//Method to be used for click buttons
		protected static void clickButton(WebElement button) 
		{
			button.click();
		}
	//Method to be used to SendKeys to the text boxes and search fields	
		protected static void setTextElementText(WebElement textElement , String value) 
		{
			textElement.sendKeys(value);
		}
		
	//Method to be used Clear the text boxes and search Fields	
		public void clearText(WebElement element) 
		{
			element.clear();
		}
		

}
