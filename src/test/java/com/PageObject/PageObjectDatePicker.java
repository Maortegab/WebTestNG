package com.PageObject;

import java.io.File;



import org.openqa.selenium.WebDriver;


import com.MapObject.MapObjectDatePicker;



public class PageObjectDatePicker extends MapObjectDatePicker {

	public PageObjectDatePicker(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void urlAcceso(String url) {
		driver.get(url);
	}
	// Inicio flujo	

	public String IngresoDemoQA(String Fecha1, String Fecha2, File rutaCarpeta,String generarEvidencia) throws Exception {
		try {
			
		
		click(btnWidgets, rutaCarpeta, generarEvidencia);
		click(btnDatePicker, rutaCarpeta, generarEvidencia);		
		click(btnSelectDate, rutaCarpeta,generarEvidencia);
		tiempoEspera(1);
		ctrlA(btnSelectDate);
		tiempoEspera(1);
		backspace(btnSelectDate);
		tiempoEspera(1);
		sendKey(Fecha1, btnSelectDate, rutaCarpeta,generarEvidencia);
		enter(btnSelectDate);
		tiempoEspera(1);
		click(txtDateAndTime, rutaCarpeta, generarEvidencia);
		tiempoEspera(1);
		ctrlA(txtDateAndTime);
		
		backspace(txtDateAndTime);
		sendKey(Fecha2, txtDateAndTime, rutaCarpeta,generarEvidencia);
		click(SelectHora, rutaCarpeta,generarEvidencia);
		
		
		
		tiempoEspera(2);
		click(btnHome, rutaCarpeta,generarEvidencia);
		tiempoEspera(2);
		} catch (Exception e) {
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
		return valor;
	}
}
