package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImagesCount = By.cssSelector("div#content a.thumbnail");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHeader() {
		String header = eleUtil.doGetText(productHeader);
		System.out.println("product header ===" + header);
		return header;
	}
	
	
	public int getProductImagesCount() {
		int imagesCount =
				eleUtil.waitForVisibilityOfElemenetsLocated(productImagesCount, TimeUtil.DEFAULT_MEDIUM_TIME).size();
		System.out.println("total images ==" + imagesCount);
		return imagesCount;
	}
	
	

}

