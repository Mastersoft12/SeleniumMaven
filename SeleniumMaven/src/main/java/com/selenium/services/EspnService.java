package com.selenium.services;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.util.BusquedaEnum;

public class EspnService implements IEspn {

	public static final String urlEspan = "http://espndeportes.espn.com/";
	
	private WebDriver driver;
	

	public String ultimoMarcadorRealMadrid() {
		String urlTablaPosicion = "";
		try {
		iniciaizarComponentes();
		irPagina(urlEspan);
		urlTablaPosicion = irLiga();
		driver.get(urlTablaPosicion);
		irPagina(buscarEquipo());
		buscarUltimoPartido();
		}catch (InvalidSelectorException e) {
			System.err.println("Error: "+e);
		}
		return null;
	}

	private void irPagina(String pagina) {		
		driver.get(pagina);
	}
	
	private String irLiga() {		
		Actions action = new Actions(driver);
		WebElement element = obtenerWebDriver("link-text", BusquedaEnum.CLASS);
		action.moveToElement(element).perform();
		WebElement link = driver.findElement(By.xpath("//*[@id=\"global-nav\"]/ul/li[1]/div/ul[2]/li/div/div/ul[1]/li[2]/span[2]/span/h3/a"));
		return link.getAttribute("href");
	}
	
	private String buscarEquipo() {
		WebElement element = obtenerWebDriver("//*[@id=\"main-container\"]/div/section[2]/article[2]/div/table/tbody/tr[3]/td[1]/a", BusquedaEnum.XPAHT);
	    return element.getAttribute("href");	
	}
	
	private String buscarUltimoPartido() {
		WebElement element = obtenerWebDriver("//*[@id=\"main-container\"]/div/section[1]/section/ul/ul/li[1]/header/a", BusquedaEnum.XPAHT);
		System.err.println("Texto: "+element.getText().replace("\n", ""));
		return element.getText();
	}
	
	private WebElement obtenerWebDriver(String clave, BusquedaEnum tipoBusqueda) {
		WebElement element = null;		
		switch (tipoBusqueda) {
		case XPAHT:
			element  = driver.findElement(By.xpath(clave));
			break;
		case CLASS:
			element  = driver.findElement(By.className(clave));
			break;
		case NAME:
			element  = driver.findElement(By.name(clave));
			break;
		case ID:
			element  = driver.findElement(By.id(clave));
			break;

		default:
			break;
		}
		return element;
	}
	
	public void iniciaizarComponentes() {
		if(null == driver) {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver\\chromedriver.exe");
			this.driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	
	
}
