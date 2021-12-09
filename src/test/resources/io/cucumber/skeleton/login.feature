Feature: Login
  Como usuarios de la página web
  queremos loguearnos con nuestro usuario.


  Scenario: Login correcto
    Given Voy a la pagina de inicio
    Then Deberia ver el boton de "login__link"
    When Hago clic en el boton de "Iniciar sesión"
    Then Deberia ver el boton de "Login_email_address"