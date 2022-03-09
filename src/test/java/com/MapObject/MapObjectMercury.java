package com.MapObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.TestNG.ClaseBase;

public class MapObjectMercury extends ClaseBase {
  public MapObjectMercury(WebDriver driver) {
		super(driver);
		
  }
  
  	protected By btnRegistro = By.xpath("//a[@href='register.php']\"");
	protected By txtHome= By.xpath("/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a");
	protected By btnRegister= By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a");
	protected By txtFirstName= By.name("firstName");
	protected By txtLastName= By.name("lastName");
	protected By txtPhone= By.name("phone");
	protected By txtEmail= By.name("userName");
	protected By txtAdress= By.name("address1");
	protected By txtCity= By.name("city");
	protected By txtState= By.name("state");
	protected By txtPostalCode= By.name("postalCode");
	protected By txtCountry= By.name("country");
	protected By txtUserName= By.name("email");
	protected By txtPassword= By.name("password");
	protected By txtConfirmPassword= By.name("confirmPassword");
	protected By btnEnviar= By.name("submit");	
	protected By resultado =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td");
}
