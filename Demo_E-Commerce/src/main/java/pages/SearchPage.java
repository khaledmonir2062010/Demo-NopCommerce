package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	//This is the search Field
	@FindBy(id="small-searchterms")
	WebElement searchTextBox ; 

	//This is the search button
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn ; 

	//This is the Auto complete suggestion #1
	@FindBy(id="ui-id-1")
	List<WebElement> ProductList ;


	//Product title
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;



	public void ProductSearch(String productName) 
	{
		setTextElementText(searchTextBox, productName);
		clickButton(searchBtn);
	}

	public void OpenProductDetailsPage() 
	{
		clickButton(productTitle);
	}
	
	public void ProductSearchUsingAutoSuggest(String SearchTxt)
	{
		setTextElementText(searchTextBox, SearchTxt);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProductList.get(0).click();
	}


}
