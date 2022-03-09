package com.MapObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.TestNG.ClaseBase;

public class MapObjectMercadoLibre extends ClaseBase {

	public MapObjectMercadoLibre(WebDriver driver) {
		super(driver);
		
	}
//	elementos para ingresar a mercadoLibre
	protected By txtBusquedaMercadoLibre= By.xpath("//*[@id=\"cb1-edit\"]");
	protected By btnLupa= By.xpath("/html/body/header/div/form/button");
	protected By primerResultado = By.xpath("//h2[contains(text(),'Bicicicleta Roadmaster Hurricane 29')]");
	
	protected By creaCuenta = By.xpath("//nav[@id='nav-header-menu']//a[contains(text(),'Crea tu cuenta')]");
	protected By btnContinuar = By.xpath("//span[@class='andes-button__content']");
	protected By resultado = By.xpath("//h1[normalize-space()='Tus datos']");
	
 
}
