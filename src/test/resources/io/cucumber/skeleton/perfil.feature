Feature: El usuario modifica opciones de perfil
  Scenario: Inicia sesion y cambia el nombre de la cuenta pero falla porque no rellena todos los campos
    Given Voy a la pagina de inicio
    When Hago clic en el boton de "Iniciar sesión"
    And Inserto el texto "practicastqs@gmail.com" en el boton "Login_email_address"
    And Inserto el texto "practicastqs" en el boton "Login_password"
    And Iniciar sesión
    And Hago clic en mi perfil
    And Hago clic en el boton de "Datos de la cuenta"
    And Inserto el texto "tqs2" en el boton "Account_firstname"
    And Guardo los cambios
    And Espero "2" segundo
    Then Deberia ver el texto "Lo sentimos, se encontró un problema en los datos enviados."

  Scenario: Inicia sesión y cambia el nombre de la cuenta correctamente
    Given Voy a la pagina de inicio
    When Hago clic en el boton de "Iniciar sesión"
    And Inserto el texto "practicastqs@gmail.com" en el boton "Login_email_address"
    And Inserto el texto "practicastqs" en el boton "Login_password"
    And Iniciar sesión
    And Hago clic en mi perfil
    And Hago clic en el boton de "Datos de la cuenta"
    And Inserto el texto "tqs2" en el boton "Account_firstname"
    And Inserto el texto "652728914" en el boton "Account_telephone"
    And Espero "2" segundo
    And Guardo los cambios
    Then Deberia ver el texto "Tu cuenta personal se ha actualizado correctamente."

  Scenario: El usuario añade una dirección de envio
    Given Voy a la pagina de inicio
    When Hago clic en el boton de "Iniciar sesión"
    And Inserto el texto "practicastqs@gmail.com" en el boton "Login_email_address"
    And Inserto el texto "practicastqs" en el boton "Login_password"
    And Iniciar sesión
    And Hago clic en mi perfil
    And Espero "2" segundo
    And Hago clic en el boton de "Libreta de direcciones"
    And Añado una dirección
    And Inserto el texto "tqs" en el boton "Address_name"
    And Inserto el texto "8888" en el boton "Address_street_address"
    And Inserto el texto "sfasdjfadfa" en el boton "Address_house_number"
    And Inserto el texto "codigopostalenletras" en el boton "Address_postcode"
    And Inserto el texto "Bellaterra" en el boton "Address_city"
    And Inserto el texto "665433254" en el boton "Address_telephone"
    And Hago clic en el boton de "AÑADIR DIRECCIÓN"
    And Espero "2" segundo