package StepDefinitionRunner;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.SeleniumUtilitario;



public class StepDefinitionGeneral {
	private static final String TEXTOAINGRESAR = "TEXTOAINGRESAR";
	WebDriver driver;
	String logoInicio;
	String xpathlogo = "//img[@src='/images/nav/logo.gif";
	String xpathlogoHoteles = "//img[@src='/images/masts/mast_construction.gif']";
	
	public StepDefinitionGeneral(SeleniumUtilitario webdriver) {
		driver = webdriver.open();
	}
	
	
	@Given("^Ingresa a la pagina de viaje$")
	public void ingresa_a_la_pagina_de_viaje() {
		driver.get("http://newtours.demoaut.com/");
		SeleniumUtilitario.log("Se ingresa a la pagina.");
	
	}
	
	@When("^Obtiene el titulo de la pagina$")
	public void obtiene_el_titulo_de_la_pagina() {
		logoInicio = driver.findElement(By.xpath(xpathlogo)).getAttribute("alt");
		
	}
	
	@Then("^Valida que ingreso correctamente$")
	public void valida_que_ingreso_correctamente(){
		    if(logoInicio.equalsIgnoreCase("Mercury Tours")) {
		    	SeleniumUtilitario.log("Se valida correctamente el logo de la pagina.");	
		    }else {
		    	SeleniumUtilitario.log("No se encontro el logo de la pagina.");	
		    }
	}
	
	@Given("^Acceder al formulario de registro$")
	public void acceder_al_formulario_de_registro() throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'registration')]")).click();
		SeleniumUtilitario.log("Se ingresa al formulario de registro.");
	}
	
	@When("^Se dirige a la seccion de \"([^\"]*)\"$")
	public void se_dirige_a_la_seccion_de(String seccion) {
	   String xpathSeccionHoteles = SeleniumUtilitario.reemplazarEnXpath("//a[contains(text(),'TEXTOAINGRESAR')]",TEXTOAINGRESAR, seccion);
		driver.findElement(By.xpath(xpathSeccionHoteles)).click();
		SeleniumUtilitario.log("Se ingresa a la seccion de hoteles.");
		SeleniumUtilitario.capturarPantalla(driver, "Test1");
		

	}
	@Then("^Validar que la seccion se encuentre en construccion$")
	public void validar_que_la_seccion_se_encuentre_en_construccion() {
		WebElement logoHotel = driver.findElement(By.xpath("//img[@src='/images/masts/mast_construction.gif']"));
		if(logoHotel.isDisplayed()) {
			SeleniumUtilitario.log("La seccion de hoteles se encuentra en construccion.");
			SeleniumUtilitario.capturarPantalla(driver, "Test2");
		}else {
			SeleniumUtilitario.log("Error al validar la seccion de hoteles.");
		}
	}

	
	@After
	public void tearDown() {
		driver.quit();
		driver = null;
		SeleniumUtilitario.log("Se cierra el webdriver.");	
	}
	
}
