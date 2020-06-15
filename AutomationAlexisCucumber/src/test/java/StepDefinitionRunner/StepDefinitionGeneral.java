package StepDefinitionRunner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;
import utilities.logger;


public class StepDefinitionGeneral {
	WebDriver driver;
	String logoInicio;
	String xpathlogo = "//img[@src='/images/nav/logo.gif";
	
	public StepDefinitionGeneral(DriverFactory webdriver) {
		driver = webdriver.open();
	}
	
	
	@Given("^Ingresa a la pagina de viaje$")
	public void ingresa_a_la_pagina_de_viaje() {
		driver.get("http://newtours.demoaut.com/");
		logger.log("Se ingresa a la pagina.");
	}
	
	@When("^Obtiene el titulo de la pagina$")
	public void obtiene_el_titulo_de_la_pagina() {
		logoInicio = driver.findElement(By.xpath(xpathlogo)).getAttribute("alt");
		
	}
	
	@Then("^Valida que ingreso correctamente$")
	public void valida_que_ingreso_correctamente(){
		    if(logoInicio.equalsIgnoreCase("Mercury Tours")) {
		    	logger.log("Se valida correctamente el logo de la pagina.");	
		    }else {
		    	logger.log("No se encontro el logo de la pagina.");	
		    }
	}
	
	@Given("^Acceder al formulario de registro$")
	public void acceder_al_formulario_de_registro() throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'registration')]")).click();
		logger.log("Se ingresa al formulario de registro.");
	}

	@After
	public void tearDown() {
		driver.quit();
		driver = null;
		logger.log("Se cierra el webdriver.");	
	}
	
}
