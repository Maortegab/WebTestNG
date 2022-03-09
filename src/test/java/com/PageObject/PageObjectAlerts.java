package com.PageObject;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.MapObject.MapObjectAlerts;
import com.itextpdf.text.log.SysoCounter;

public class PageObjectAlerts extends MapObjectAlerts {

	public PageObjectAlerts(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String IngresoDemoQA(String FirstName, File rutaCarpeta, String generarEvidencia) throws Exception {
		try {

			// Inicio flujo
			clickDato(btnAlertsFrameWindows, generarEvidencia);
			clickDato(btnAlerts, generarEvidencia);
//		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
//		
			clickDato(btnClic1, generarEvidencia);
			driver.switchTo().alert().dismiss();
			tiempoEspera(1);
			clickDato(btnClic2, generarEvidencia);
			tiempoEspera(6);
			driver.switchTo().alert().dismiss();
			tiempoEspera(1);
			clickDato(btnClic3, generarEvidencia);
			tiempoEspera(1);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(1);
			clickDato(btnClic3, generarEvidencia);
			tiempoEspera(1);
			driver.switchTo().alert().dismiss();
			tiempoEspera(1);
			clickDato(btnClic4, generarEvidencia);
			tiempoEspera(1);
			driver.switchTo().alert().sendKeys(FirstName);
			alert();
			captureScreen(rutaCarpeta, alerts, generarEvidencia);

			tiempoEspera(1);
			click(btnHome, rutaCarpeta, generarEvidencia);
		} catch (Exception e) {
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
		return valor;
	}
}
