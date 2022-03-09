package com.MapObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.TestNG.ClaseBase;

public class MapObjectAlerts extends ClaseBase {
  public MapObjectAlerts(WebDriver driver) {
		super(driver);
	}
  
//  datos alerts
	//Ingresamos al menú alerts
	protected By btnAlertsFrameWindows = By.xpath("//div[3]//div[1]//div[2]//*[name()='svg']");
	protected By btnAlerts = By.xpath("//span[normalize-space()='Alerts']");
	
	//Botones de alerta
	
	//See alert
	protected By btnSeeAlert = By.xpath("(//button[@id='alertButton'])[1]");
	//Time alert
	protected By btnSTimeAlert = By.xpath("//button[@id='timerAlertButton']");
	//Confirm alert
	protected By btnConfirmAlert = By.xpath("(//button[@id='confirmButton'])[1]");
	//TextBox
	protected By btnTextBoxAlert = By.xpath("(//button[@id='promtButton'])[1]");	
	protected By btnHome= By.xpath("(//img[@src='/images/Toolsqa.jpg'])[1]");
	
	
	protected By btnClic1 = By.xpath("//button[@id='alertButton']");
	protected By btnClic2 = By.xpath("//button[@id='timerAlertButton']");
	protected By btnClic3 = By.xpath("//button[@id='confirmButton']");
	protected By btnClic4 = By.xpath("//button[@id='promtButton']");
	protected By txtIngresar = By.xpath("");
	protected By alertsFrame= By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/span[1]/div[1]/div[1]");
	protected By alerts= By.xpath("//span[contains(text(),'Alerts')]");
	protected By resultado= By.xpath("//img[@alt='Selenium Online Training']");
}
