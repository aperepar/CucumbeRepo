package StepDefinitionRunner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.SeleniumUtilitario;


public class SDregistrarUsuarioPaginaViajes {

    WebDriver driver;
    WebElement registroExitoso;
    String firstName = "//input[@name='firstName']";

	public SDregistrarUsuarioPaginaViajes(SeleniumUtilitario webdriver){
		driver = webdriver.open();
	}
	
 
	@When("^Ingresar nombre \"([^\"]*)\"$")
	public void ingresar_nombre(String nombre) throws InterruptedException{
		//driver.findElement(By.name("firstName")).sendKeys(nombre);
		driver.findElement(By.xpath(firstName)).sendKeys(nombre);
	}
	
	@When("^Ingresar apellido \"([^\"]*)\"$")
	public void ingresar_apellido(String apellido) throws InterruptedException{
		driver.findElement(By.name("lastName")).sendKeys(apellido);	
	}
	
	@When("^Ingresar telefono \"([^\"]*)\"$")
	public void ingresar_telefono(String telefono) throws InterruptedException{
		driver.findElement(By.name("phone")).sendKeys(telefono);	
	}
	
	@When("^Ingresar email \"([^\"]*)\"$")
	public void ingresar_email(String email) throws InterruptedException{
		driver.findElement(By.name("userName")).sendKeys(email);	
	}
	
	@When("^Ingresar direccion \"([^\"]*)\"$")
	public void ingresar_direccion(String direccion) throws InterruptedException{
		driver.findElement(By.name("address1")).sendKeys(direccion);	
	}
	
	@When("^Ingresar ciudad \"([^\"]*)\"$")
	public void ingresar_ciudad(String ciudad) throws InterruptedException{
		driver.findElement(By.name("city")).sendKeys(ciudad);	
	}
	
	@When("^Ingresar provincia \"([^\"]*)\"$")
	public void ingresar_provincia(String provincia) throws InterruptedException{
		driver.findElement(By.name("state")).sendKeys(provincia);	
	}
	
	@When("^Ingresar codigo postal \"([^\"]*)\"$")
	public void ingresar_codigo_postal(String cp) throws InterruptedException{
		driver.findElement(By.name("postalCode")).sendKeys(cp);	
	}
	
	@When("^seleccionar pais$")
	public void seleccionar_pais() {
		Select listaPaises = new Select (driver.findElement(By.name("country")));
	      listaPaises.selectByVisibleText("ARGENTINA ");
	}
	
	@When("^Ingresar username \"([^\"]*)\"$")
	public void ingresar_username(String username) throws InterruptedException{
		driver.findElement(By.name("email")).sendKeys(username);
 
	}
	
	@When("^Ingresar password \"([^\"]*)\"$")
	public void ingresar_password(String password) throws InterruptedException{
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(password);	
	}
	
	@When("^Click a boton de registo$")
	public void click_a_boton_de_registro() throws InterruptedException{
		driver.findElement(By.name("register")).click();
	}
	
	@Then("^Validar registro de usuario$")
	public void validar_registro_de_usuario()  throws InterruptedException{
		registroExitoso= driver.findElement(By.xpath("//font[contains(.,'Thank you for registering')]"));
		String textoUsername = driver.findElement(By.xpath("//b[contains(text(),' Note: Your user name is aperepar.')]")).getText();
		SeleniumUtilitario.log(textoUsername);
		if(registroExitoso.isDisplayed()) {
			SeleniumUtilitario.log("Registro de usuario exitoso!");
		}else {
			SeleniumUtilitario.log("No se registro el usuario");
		}
		
	}
	
}
