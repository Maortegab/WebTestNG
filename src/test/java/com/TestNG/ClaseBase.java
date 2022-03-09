package com.TestNG;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.GenerarReportePdf;

public class ClaseBase {

	protected WebDriver driver;
	String rutaOutput;

	public void setRutaOutput(String rutaOutput) {
		this.rutaOutput = rutaOutput;
	}

	// constructor de la clase
	public ClaseBase(WebDriver driver) {
		super();
	}

	// Método del navegador
	public static WebDriver chromeDriverConnection() {
		// Setear las opciones del navegador
		WebDriver _driver = null;
		try {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

			// Setear las propiedades del navegador
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			_driver = new ChromeDriver();

			// Maximiza el navegador
			_driver.manage().window().maximize();
			return _driver;
		} catch (

		Exception e) {
			System.out.println(e);
		}
		return _driver;

	}

	// Método Click
	public void click(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		try {

			driver.findElement(locator).click();
			tiempoEspera(1);
			captureScreen(rutaCarpeta, locator, generarEvidencia);
		} catch (Exception e) {
			
			captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
			throw new InterruptedException();
		}
	}

	public void clickDato(By locator, String generarEvidencia) throws Exception {
		driver.findElement(locator).click();
		tiempoEspera(2);

	}

	// Método Borrar
	public void borrar(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {

		try
		{
			driver.findElement(locator).clear();
			tiempoEspera(1);
			captureScreen(rutaCarpeta, locator,generarEvidencia);
		}		
		catch (Exception e) 
		{
			captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
			throw new InterruptedException();
		}
	}

	// Método enviar texto
	public void sendKey(String inputText, By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		try
		{
			driver.findElement(locator).sendKeys(inputText);
			tiempoEspera(1);
			captureScreen(rutaCarpeta, locator,generarEvidencia);
		}		
		catch (Exception e) 
		{
			captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
			throw new InterruptedException();
		}
	}

	// Método enter Submit
	public void submit(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta, locator, generarEvidencia);
	}

	// Método tiempo de espera
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo * 1000);
	}

	public static String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public static String fechaHora2() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public String horaSistema() {

		// Tomamos La fecha del sistema
		LocalTime horaSistema = LocalTime.now();

		// Definir formato de hora
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

		// dar formato a la fecha del sistema
		String hora = fecha.format(horaSistema);
		return hora;

	}

	public void captureScreen(File rutaCarpeta, By locator, String generarEvidencia) throws Exception {

		if (generarEvidencia.equals("Si")) {
			String hora = horaSistema();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
			String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();

			// INSTANCIAMOS LA CLASE PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			// PROCEDEMOS A INSERTAR LOCALIZADOR DE IMAGEN PDF
			informePdf.crearBody(locator, rutaImagen);
			// ELIMINAR LA IMAGEN CREADA
			eliminarArchivo(rutaImagen);

		}
	}

	public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError)
			throws Exception {
		if (generarEvidencia.equals("Si")) {
			String hora = horaSistema();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
			String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();

			// INSTACIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			// SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
			informePdf.crearbodyError(locator, rutaImagen, msnError);
			// ELIMINAR IMAGEN CREADA

			eliminarArchivo(rutaImagen);
		}
	}

	public void eliminarArchivo(String rutaImagen) {
		File fichero = new File(rutaImagen);
		fichero.delete();
	}

	public File crearCarpeta(String nomTest) {

		// Almacenamos la fecha del sistema
		String fecha = fechaHora();

		// Creamos el nombre de la carpeta
		String nomCarpeta = nomTest + "-" + fecha;

		// Obtenemos la ruta de alojamiento de salida y el nombre dek test a ejecutar
		File directorio = new File("./output/" + nomCarpeta);

		// Creamos la carpeta
		directorio.mkdir();
		return directorio;
	}

	// Método inicial
	public void urlAcceso(String url) {
		driver.get(url);
	}

	public void enter(By locator) {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException a) {
			a.printStackTrace();
		}
	}

	public void backspace(By locator) {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
		} catch (AWTException a) {
			a.printStackTrace();
		}
	}

	public void ctrlA(By locator) {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
		} catch (AWTException a) {
			a.printStackTrace();
		}
	}

	public void alert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String capturarValorSelenium(By locator) throws Exception {
		String valor = driver.findElement(locator).getText();
		return valor;
	}

}
