package com.message;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class yahooSend extends Driver {
	public static String baseUrl= "https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin";

	
	@BeforeTest
	public void logIn() throws InterruptedException{
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(1000);
     
        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("shadikunnahar");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='login-signin']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys("Zahin@123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='ybarMailLink']")).click();
        Thread.sleep(1000);
        

	} 
	@Test (priority=0)
	public void sendMessage() throws InterruptedException{
		driver.findElement(By.xpath("//a[normalize-space()='Compose']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='message-to-field']")).sendKeys("sakiba256@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Test Mail");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("Dear sakiba\n"
        		+ "Hope you are well.\n"
        		+ "Thank you.");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Send this email']")).click();
        Thread.sleep(1000);
		
	}
	
	
	@Test (priority = 1)
	public void logout() throws InterruptedException{
		
		Actions action= new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//label[@id='ybarAccountMenuOpener']"))).build().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@class='_yb_1ads0 _yb_1ntt0 _yb_qy3a6 _yb_10xbl _yb_1lzse']")).click();
		Thread.sleep(3000);
	}
	
	
}
