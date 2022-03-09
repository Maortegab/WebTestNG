package com.PageObject;

import java.io.File;

import org.openqa.selenium.WebDriver;


import com.MapObject.MapObjectMercadoLibre;

public class PageObjectMercadoLibre extends MapObjectMercadoLibre {
	
	String urlML;

	public void setUrlML(String urlML) {
		this.urlML = urlML;
	}

	public PageObjectMercadoLibre(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	// Método inicial Abrir link

		public void urlAcceso() {
			driver.get(urlML);
		}
		
		public String busquedaMerLib(String Producto, String nomtest,File rutacarpeta, String generarEvidencia) throws Exception {

			try {				
			
			//			Buscando en mercadoLibre				
			sendKey(Producto,txtBusquedaMercadoLibre,rutacarpeta,generarEvidencia);
			tiempoEspera(1);
			click(btnLupa, rutacarpeta,generarEvidencia);
			tiempoEspera(1);
			click(primerResultado, rutacarpeta,generarEvidencia);
			tiempoEspera(1);
			click(creaCuenta, rutacarpeta,generarEvidencia);
			tiempoEspera(1);
			click(btnContinuar, rutacarpeta,generarEvidencia);
			} catch (Exception e) {
				System.out.println(e);
			}
			String valor = capturarValorSelenium(resultado);
			return valor;
		}

}
