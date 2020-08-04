Feature: Primer escenario de prueba cucumber


Scenario: Entrar a pagina de viaje y validar apertura
Given Ingresa a la pagina de viaje
When Obtiene el titulo de la pagina
Then Valida que ingreso correctamente


Scenario: Entrar a pagina de viaje, registrar usuario y validar registro exitoso
Given Ingresa a la pagina de viaje
Given Acceder al formulario de registro
When Ingresar nombre "Alexis"
When Ingresar apellido "Perez"
When Ingresar telefono "1111111111"
When Ingresar email "a@a.com"
When Ingresar direccion "Flores"
When Ingresar ciudad "Capital Federal"
When Ingresar provincia "Buenos Aires"
When Ingresar codigo postal "1406"
When seleccionar pais
When Ingresar username "aperepar"
When Ingresar password "12345"
When Click a boton de registo
Then Validar registro de usuario


Scenario: Entrar a la pagina de viajes, ir a la seccion de hoteles y comprobar que esta en construccion la seccion
Given Ingresa a la pagina de viaje
When Se dirige a la seccion de "Vacations"
Then Validar que la seccion se encuentre en construccion

@correr1
Scenario: Entrar a la pagina SauceDemo, ingresar usuario, contrasena y loguear
Given Ingresa a la pagina de SauceDemo
When Se completa campo Usuario con "standard_user"
When Se completa campo Contrasena con "secret_sauce"
When Se realiza click en boton Login
Then Validar logueo exitoso

@correr2
Scenario: Entrar a la pagina SauceDemo, ingresar contrasena, usuario y loguear
Given Ingresa a la pagina de SauceDemo
When Se completa campo Contrasena con "standard_user"
When Se completa campo Usuario con "secret_sauce"
When Se realiza click en boton Login
Then Validar logueo exitoso


