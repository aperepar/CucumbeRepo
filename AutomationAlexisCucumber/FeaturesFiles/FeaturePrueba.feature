Feature: Primer escenario de prueba cucumber

@correr1
Scenario: Entrar a pagina de viaje y validar apertura
Given Ingresa a la pagina de viaje
When Obtiene el titulo de la pagina
Then Valida que ingreso correctamente

@correr1
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