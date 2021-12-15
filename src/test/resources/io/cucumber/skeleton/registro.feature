Feature: Registro
  Como usuario de la página web
  queremos registrarnos

  Scenario: Pagina de Registro
    Given Voy a la pagina de inicio
    Then Deberia ver el boton de "register__link"
    When Hago clic en el boton de "Crear cuenta"
    Then Deberia ver el boton de "CreateAccount_firstname"

  Scenario: Registro vacio
    Given Voy a la pagina de inicio
    Then Deberia ver el boton de "register__link"
    When Hago clic en el boton de "Crear cuenta"
    Then Deberia ver el boton de "CreateAccount_firstname"
    When Crear cuenta
    And Espero "1" segundo
    Then Deberia ver el texto "Lo sentimos, se encontró un problema en los datos enviados."

  Scenario: Registro existente
    Given Voy a la pagina de inicio
    Then Deberia ver el boton de "register__link"
    When Hago clic en el boton de "Crear cuenta"
    Then Deberia ver el boton de "CreateAccount_firstname"
    Then Inserto el texto "ivan" en el boton "CreateAccount_firstname"
    And Inserto el texto "jimenez valencia" en el boton "CreateAccount_lastname"
    And Selecciono el genero
    And Inserto el texto "1996-11-17" en el boton "CreateAccount_dob"
    And Inserto el texto "39415726R" en el boton "CreateAccount_nif"
    And Inserto el texto "ivanjimenez.rakos@gmail.com" en el boton "CreateAccount_email_address"
    And Inserto el texto "practicatqs" en el boton "CreateAccount_password"
    And Inserto el texto "practicatqs" en el boton "CreateAccount_retype_password"
    And Acepto las cookies
    And Acepto terminos

    And Espero "1" segundo
    And Crear cuenta
    And Espero "1" segundo
    Then Deberia ver el texto "Tu email ya se encuentra en nuestra base de datos."


