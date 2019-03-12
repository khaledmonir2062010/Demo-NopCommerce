package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductusingAutoSuggest_testcase2 extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage ProductDetailsObject;

	@Test(priority=1,alwaysRun=true)
	public void UserCanSearchWithAutoComplete()
	{
		try {
			searchObject = new SearchPage(driver); 
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			ProductDetailsObject = new ProductDetailsPage(driver); 
			Assert.assertEquals(ProductDetailsObject.productNameBreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
		
	}


}
