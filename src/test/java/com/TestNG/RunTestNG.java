package com.TestNG;



import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.PageObject.PageObjectAlerts;
import com.PageObject.PageObjectDatePicker;
import com.PageObject.PageObjectDemoQA;
import com.PageObject.PageObjectMercadoLibre;
import com.PageObject.PageObjectMercury;
import com.Utilities.ExcelUtilities;
import com.Utilities.GenerarReportePdf;
import com.Utilities.MyScreenRecorder;

public class RunTestNG {

	WebDriver driver;
	PageObjectMercury mercury;
	ClaseBase claseBase;
	PageObjectMercadoLibre mercadoLibre;
	PageObjectDemoQA demo;
	File rutaCarpeta = null;
	PageObjectDatePicker datePicker;
	PageObjectAlerts alerts;
	GenerarReportePdf generarReportePdf;
	String valor;

//	------------------------@before Mercury----------------------------
	@BeforeClass
	@Parameters({ "urlMercury", "urlMercadoLibre", "urlTools", "rutaOutput", "rutaImagenReporte" })
	public void beforeClass(@Optional("default") String urlMercury,
							@Optional("default") String urlMercadoLibre,
							@Optional("default") String urlTools,
							@Optional("default") String rutaOutput,
							@Optional("default") String rutaImagenReporte) {

		driver = ClaseBase.chromeDriverConnection();
		claseBase = new ClaseBase(driver);	
		generarReportePdf = new GenerarReportePdf();
//		 Instanciación de mercury
		mercury = new PageObjectMercury(driver);
//		setear urlMercury

		mercury.setUrlM(urlMercury);
		generarReportePdf.setRutaImagen(rutaImagenReporte);
		claseBase.setRutaOutput(rutaOutput);

		// Instanciación de mercadoLibre

		mercadoLibre = new PageObjectMercadoLibre(driver);
		mercadoLibre.setUrlML(urlMercadoLibre);

		// Instanciación de mercadoLibre

		demo = new PageObjectDemoQA(driver);
		datePicker = new PageObjectDatePicker(driver);
		alerts = new PageObjectAlerts(driver);

		demo.setUrlT(urlTools);
	}

//	------------------------@test Mercury----------------------------
	@Test(dataProvider = "datosMercury")
	public void pruebaInicialTestNG(String Ejecucion, String generarEvidencia, String firstName, String lastName,
			String phone, String email, String address, String city, String state, String postalCode, String country,
			String userName, String password) throws Exception {

//		boolean v = false;
		if (Ejecucion.equals("Si")) {

			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			//ACCEDER A LA URL
			mercury.urlAcceso();

			if (generarEvidencia.contains("Si")) {

				// CREA CARPETA PARA ALMACENAMIENTO DE EVIDENCIAS
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIO GRABACIÓN DE VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);

				// INICIA CREACIÓN DE REPORTE PDF
				generarReportePdf.crearPlatilla(nomTest, rutaCarpeta);

				//
				valor=mercury.registro(generarEvidencia, firstName, lastName, phone, email, address, city, state,
						postalCode, country, userName, password, rutaCarpeta, nomTest);

				MyScreenRecorder.stopRecording();

				generarReportePdf.cerrarPlantilla();

			} else {
				
				valor=mercury.registro(generarEvidencia, firstName, lastName, phone, email, address, city, state,
						postalCode, country, userName, password, rutaCarpeta, nomTest);

			}
			assert valor.contains(firstName);
		}

	}



//	------------------------@test MercadoLibre----------------------------

	@Test(dataProvider = "datosMercadoLibre")
	public void mercadoLibreTestNG(String Ejecucion, String generarEvidencia, String Producto) throws Exception {

//		boolean v = false;
		if (Ejecucion.equals("Si")) {

			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			//ACCEDER A LA URL
			mercadoLibre.urlAcceso();

			if (generarEvidencia.contains("Si")) {

				// CREA CARPETA PARA ALMACENAMIENTO DE EVIDENCIAS
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIO GRABACIÓN DE VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);

				// INICIA CREACIÓN DE REPORTE PDF
				generarReportePdf.crearPlatilla(nomTest, rutaCarpeta);

				//
				valor=mercadoLibre.busquedaMerLib(Producto,  nomTest,rutaCarpeta,generarEvidencia);

				MyScreenRecorder.stopRecording();

				generarReportePdf.cerrarPlantilla();

			} else {
				
				valor=mercadoLibre.busquedaMerLib(Producto, nomTest,  rutaCarpeta, generarEvidencia);
			}
			assert valor.contains("datos");
		}

	}


	@Test(dataProvider = "datosTools")
//	public void toolsQATestNG(String Ejecucion, String generarEvidencia, String FirstName, String LastName,
//			String Email, String Age, String Salary, String Departament, String posicionBorr, String Fecha1,
//			String Fecha2) throws Exception {
//		boolean v = false;
//
//		if (Ejecucion.equals("Si")) {
//
//			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
//			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
//
//			if (generarEvidencia.equals("Si")) {
//
//				// Inicio Grabación
//				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
//				v = true;
//			}
////			Ejecución de set de DemoQA
//			demo.urlAcceso();
////			demo.IngresoDemoQA(FirstName, LastName, Email, Age, Salary, Departament, posicionBorr, rutaCarpeta);
////			datePicker.IngresoDemoQA(Fecha1, Fecha2, rutaCarpeta);
//			alerts.IngresoDemoQA(FirstName, rutaCarpeta, nomTest);
//
//			if (Boolean.TRUE.equals(v)) {
//				// Fin de Grabación
//				MyScreenRecorder.stopRecording();
//			}
//		}
//	}
	public void toolsQATestNG(String Ejecucion, String generarEvidencia, String FirstName, String LastName,
			String Email, String Age, String Salary, String Departament, String posicionBorr, String Fecha1,
			String Fecha2) throws Exception {

//		boolean v = false;
		if (Ejecucion.equals("Si")) {

			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			//ACCEDER A LA URL
			demo.urlAcceso();

			if (generarEvidencia.contains("Si")) {

				// CREA CARPETA PARA ALMACENAMIENTO DE EVIDENCIAS
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIO GRABACIÓN DE VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);

				// INICIA CREACIÓN DE REPORTE PDF
				generarReportePdf.crearPlatilla(nomTest, rutaCarpeta);

				//
				valor=demo.IngresoDemoQA(FirstName, LastName, Email, Age, Salary, Departament, posicionBorr, rutaCarpeta,generarEvidencia);
				valor=datePicker.IngresoDemoQA(Fecha1, Fecha2, rutaCarpeta,generarEvidencia);
//				valor=alerts.IngresoDemoQA(FirstName, rutaCarpeta, nomTest,generarEvidencia);

				MyScreenRecorder.stopRecording();

				generarReportePdf.cerrarPlantilla();

			} else {
				
				valor=demo.IngresoDemoQA(FirstName, LastName, Email, Age, Salary, Departament, posicionBorr, rutaCarpeta,generarEvidencia);
				valor=datePicker.IngresoDemoQA(Fecha1, Fecha2, rutaCarpeta,generarEvidencia);
//				valor=alerts.IngresoDemoQA(FirstName, rutaCarpeta, nomTest,generarEvidencia);
			}
			assert valor.contains("datos");
		}

	}

	@DataProvider(name = "datosMercury")
	public Object[][] datos() throws Exception {
		Object[][] arreglo = ExcelUtilities.getTableArray("./Data/archivo.xlsx", "Mercury");
		return arreglo;
	}

	@DataProvider(name = "datosMercadoLibre")
	public Object[][] datosML() throws Exception {
		Object[][] arreglo = ExcelUtilities.getTableArray("./Data/archivo.xlsx", "MercadoLibre");
		return arreglo;
	}

	@DataProvider(name = "datosTools")
	public Object[][] datosDemoQA() throws Exception {
		Object[][] arreglo = ExcelUtilities.getTableArray("./Data/archivo.xlsx", "ToolsQA");
		return arreglo;
	}

//----------------------------------@AfterClass--------------------------------------
	@AfterClass
	public void afterClass() {

		driver.close();

	}

}
