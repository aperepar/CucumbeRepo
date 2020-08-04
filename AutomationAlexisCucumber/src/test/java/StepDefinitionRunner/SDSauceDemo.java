package StepDefinitionRunner;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.SeleniumUtilitario;


public class SDSauceDemo {
	
	WebDriver driver;
	String ERROR = "ERROR";
	
	
	public SDSauceDemo(SeleniumUtilitario webdriver){
		driver = webdriver.open();
	}
	
	@Given("^Ingresa a la pagina de SauceDemo$")
	public void ingresa_a_la_pagina_de_sauceDemo(){
		driver.get("https://www.saucedemo.com/");
		SeleniumUtilitario.log("Se ingresa a la pagina.");
		SeleniumUtilitario.capturarPantalla(driver, "ingresa_a_la_pagina_de_sauceDemo");
	}
	
	@When("Se completa campo Usuario con \"([^\"]*)\"$")
	public void se_completa_campo_usuario_con(String usuario) {
		driver.findElement(By.id("user-name")).sendKeys(usuario);
		SeleniumUtilitario.log("Se completa campo usuario.");
		SeleniumUtilitario.capturarPantalla(driver, "se_completa_campo_usuario_con" + usuario);
	}
	
	@When("^Se completa campo Contrasena con \"([^\"]*)\"$")
	public void se_completa_campo_contresena_con(String pass) {
		driver.findElement(By.id("password")).sendKeys(pass);
		SeleniumUtilitario.log("Se completa campo contrasena.");
		SeleniumUtilitario.capturarPantalla(driver, "se_completa_campo_contresena_con" + pass);
	}
	
	@When("^Se realiza click en boton Login$")
	public void se_realiza_click_en_boton_login() {
		SeleniumUtilitario.capturarPantalla(driver, "se_realiza_click_en_boton_login");
		driver.findElement(By.id("login-button")).click();
		SeleniumUtilitario.log("Se realiza click en boton login.");
	}
	
	@Then("^Validar logueo exitoso$")
	public void validar_logueo_exitoso() throws InterruptedException  {
	try {
		
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product_label']")).getText().contains("A"));
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product_label']")).getText().contains("Products"));
	SeleniumUtilitario.log("Se logueo satisfactoriamente.");
	SeleniumUtilitario.capturarPantalla(driver, "validar_logueo_exitoso");
	}catch (Exception e){
		SeleniumUtilitario.log("No se logueo correctamente.");
		SeleniumUtilitario.capturarPantalla(driver, ERROR + "validar_logueo_exitoso");
		throw new  InterruptedException() ;
		
	}
	}
	
}