package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;

public class DriverFactory {

	WebDriver driver;
	Properties prop;

	/**
	 * This is used to init the driver on the basis on given browser name.
	 * 
	 * @param browserName
	 */
	public WebDriver initDriver(Properties prop) {
		
		
		String browserName = prop.getProperty("browser");
		System.out.println("browser name is : " + browserName);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("plz pass the right browser name..." + browserName);
			throw new BrowserException(AppError.BROWSER_NOT_FOUND);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		return driver;

	}

	/**
	 * this is used to init the properties from the .properties file
	 * @return this returns properties (prop)
	 */
	public Properties initProp() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(AppConstants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;

	}

}
