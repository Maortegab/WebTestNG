package com.PageObject;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.MapObject.MapObjectMercury;

public class PageObjectMercury extends MapObjectMercury {

	String urlM;

	public void setUrlM(String urlM) {
		this.urlM = urlM;
	}

	public PageObjectMercury(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void urlAcceso() {
		driver.get(urlM);
	}

	public String registro(String generarEvidencia, String firstName, String lastName, String phone, String email,
			String address, String city, String state, String postalCode, String country, String userName,
			String password, File rutacarpeta, String nomtest) throws Exception {
		try {
			System.out.println("Hola Git");
			tiempoEspera(2);
			click(btnRegister, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(firstName, txtFirstName, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(lastName, txtLastName, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(phone, txtPhone, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(email, txtEmail, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(address, txtAdress, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(city, txtCity, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(state, txtState, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(postalCode, txtPostalCode, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(country, txtCountry, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(userName, txtUserName, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(password, txtPassword, rutacarpeta, generarEvidencia);
			tiempoEspera(1);
			sendKey(password, txtConfirmPassword, rutacarpeta, generarEvidencia);

			tiempoEspera(1);
			click(btnEnviar, rutacarpeta, generarEvidencia);

		} catch (Exception e) {
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
		return valor;

	}
}
