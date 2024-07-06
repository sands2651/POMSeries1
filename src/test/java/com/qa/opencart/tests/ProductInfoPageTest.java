package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.errors.AppError;

public class ProductInfoPageTest extends BaseTest{
	
	
	@BeforeClass
	public void productInfoPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"macbook", "MacBook Pro"},
			{"imac", "iMac"},
			{"samsung", "Samsung SyncMaster 941BW"},
			{"samsung", "Samsung Galaxy Tab 10.1"},
			{"canon", "Canon EOS 5D"}

		};
	}
	
	@Test(dataProvider = "getProductData")
	public void productHeaderTest(String searchKey, String productName) {
		searchResultsPage = accPage.doSearch(searchKey);
		productInfoPage = searchResultsPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductHeader(), productName, AppError.HEADER_NOT_FOUND);
	}
	
	
	
	@DataProvider
	public Object[][] getProductImageData() {
		return new Object[][] {
			{"macbook", "MacBook Pro", 4},
			{"imac", "iMac", 3},
			{"samsung", "Samsung SyncMaster 941BW", 1},
			{"samsung", "Samsung Galaxy Tab 10.1", 7},
			{"canon", "Canon EOS 5D", 3}

		};
	}
	
	@Test(dataProvider = "getProductImageData")
	public void productImagesCountTest(String searchKey, String productName, int imagesCount) {
		searchResultsPage = accPage.doSearch(searchKey);
		productInfoPage = searchResultsPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductImagesCount(), imagesCount, AppError.IMAGES_COUNT_MISMATCHED);
	}
	

	//act vs exp: Assert.assertEquals(act, exp)
	//Assert.assertTrue(10>5)
	//Assert.assertTrue(title.contains("Google123")) ===> +ve
	//Assert.assertFalse(false)
	//Assert.assertFalse(5>10) --- -ve
	
	
	
	
}
