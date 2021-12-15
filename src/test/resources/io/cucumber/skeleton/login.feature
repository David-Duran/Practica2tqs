Feature: Login
  Como usuarios de la página web
  queremos loguearnos con nuestro usuario.


  Scenario: Login correcto
    Given Voy a la pagina de inicio
    Then Deberia ver el boton de "login__link"
    When Hago clic en el boton de "Iniciar sesión"
    Then Deberia ver el boton de "Login_email_address"
    And Inserto el texto "practicastqs@gmail.com" en el boton "Login_email_address"
    And Inserto el texto "practicastqs" en el boton "Login_password"
    And Iniciar sesión
    And Espero "1" segundo
    Then Deberia ver el texto "Tqsa"

  Scenario: Contraseña incorrecta
    Given Voy a la pagina de inicio
    Then Deberia ver el boton de "login__link"
    When Hago clic en el boton de "Iniciar sesión"
    Then Deberia ver el boton de "Login_email_address"
    And Inserto el texto "practicastqs@gmail.com" en el boton "Login_email_address"
    And Inserto el texto "contraseñaIncorrecta" en el boton "Login_password"
    And Iniciar sesión
    And Espero "1" segundo
    Then Deberia ver el texto "Contraseña incorrecta"

  Scenario: Correo incorrecta
    Given Voy a la pagina de inicio
    Then Deberia ver el boton de "login__link"
    When Hago clic en el boton de "Iniciar sesión"
    Then Deberia ver el boton de "Login_email_address"
    And Inserto el texto "practicastqss@gmail.com" en el boton "Login_email_address"
    And Inserto el texto "practicatqs" en el boton "Login_password"
    And Iniciar sesión
    And Espero "1" segundo
    Then Deberia ver el texto "Contraseña incorrecta"