package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest_testcase1 extends TestBase {
	
	
	SearchPage searchObject;
	ProductDetailsPage ProductDetailsObject;
	
	
	@DataProvider(name="ExcelData")
	public Object[][] productName() throws IOException
	{
		//Get the data from the excel data sheet ...reader Class
		ExcelReader Er = new ExcelReader();
		
			return Er.getExcelData();
		}
		

	
	@Test(priority=0,dataProvider="ExcelData")
	public void UserCanSearchForProducts(String ProductName)
	{
		
		//This testCase will search for the product name=Apple MacBook Pro 13-inch,,,,Then it will assert that the search result is correct by the assert
		
		searchObject = new SearchPage(driver);
		ProductDetailsObject=new ProductDetailsPage(driver);
		
		//To Enter the search text name then click search
		searchObject.ProductSearch(ProductName);
		
		//To click for the searched Product
		searchObject.OpenProductDetailsPage();
		
		//Assertion to make sure that we selected the correct product after searching
		Assert.assertEquals(ProductDetailsObject.productNameBreadCrumb.getText(), ProductName);
		
	}
	
	
}
