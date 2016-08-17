package com.sample.test;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class UploadTest {
	    WebDriver driver;

	    @BeforeTest
	    public void setUp() throws Exception {
	        driver = new FirefoxDriver();
	    }
	    
	    @Test
	    public void uploadFile() throws Exception {
	        String filename = "json.txt";
	        File file = new File(filename);
	        String path = file.getAbsolutePath();
	        driver.get("http://the-internet.herokuapp.com/upload");
	        driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
	        driver.findElement(By.id("file-upload")).sendKeys(path);
	        driver.findElement(By.id("file-submit")).click();
	        String text = driver.findElement(By.id("uploaded-files")).getText();
	        Assert.assertEquals(text, filename);
	    }
	    
	    @AfterTest
	    public void tearDown() throws Exception {
	        driver.quit();
	    }
}
