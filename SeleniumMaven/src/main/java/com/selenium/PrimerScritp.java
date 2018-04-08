package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.services.EspnService;
import com.selenium.services.IEspn;

public class PrimerScritp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	System.setProperty("webdriver.gecko.driver","D:\\selenium\\chromedriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("espn");
		driver.findElement(By.name("btnK")).click();*/
		
		IEspn espn = new EspnService();
		espn.ultimoMarcadorRealMadrid();

	}

}
