package com.PageObject;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapObject.MapsObjectDemoQA;

public class PageObjectDemoQA extends MapsObjectDemoQA {

	String urlT;

	public void setUrlT(String urlT) {
		this.urlT = urlT;
	}

	public PageObjectDemoQA(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void urlAcceso() {
		driver.get(urlT);
	}

	// Método para escribir en buscador
	public String IngresoDemoQA(String FirstName, String LastName, String Email, String Age, String Salary,
			String Departament, String posicionBorr, File rutaCarpeta, String generarEvidencia) throws Exception {
		try {

			// Crear carpeta para almacenamiento de imágenes
			tiempoEspera(1);
			click(btnElements, rutaCarpeta, generarEvidencia);
			click(btnWebTablet, rutaCarpeta, generarEvidencia);
			click(btnAdd, rutaCarpeta, generarEvidencia);
			sendKey(FirstName, txtFirstName, rutaCarpeta, generarEvidencia);
			sendKey(LastName, txtLastName, rutaCarpeta, generarEvidencia);
			sendKey(Email, txtEmail, rutaCarpeta, generarEvidencia);
			sendKey(Age, txtAge, rutaCarpeta, generarEvidencia);
			sendKey(Salary, txtSalary, rutaCarpeta, generarEvidencia);
			sendKey(Departament, txtDepartment, rutaCarpeta, generarEvidencia);
			click(btnSubmit, rutaCarpeta, generarEvidencia);

			click(btnDelete, rutaCarpeta, generarEvidencia);
			tiempoEspera(3);
			// Regresamos a Home
			click(btnHome, rutaCarpeta, generarEvidencia);
			tiempoEspera(2);
		} catch (Exception e) {
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
		return valor;
	}
}
