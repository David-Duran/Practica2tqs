Feature:
  Scenario: Cambiar el idioma a ingles
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    When Hago clic en el boton con id "choose-lang"
    And Espero "1" segundo
    And Hago clic en el boton de "English"
    And Espero "2" segundo
    Then Deberia ver el texto "New in"

  Scenario: Envios a Albania
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    When Hago clic en el boton con id "choose-country"
    And Espero "2" segundo
    And Hago clic en el boton de "Albania"
    And Espero "2" segundo
    Then Deberia ver el texto "Envíos a todo el mundo"

  Scenario: Deploy del menu de ayuda
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    When Hago clic en el boton con id "top-help-link"
    And Espero "2" segundo
    Then Deberia ver el texto "¿Necesitas Ayuda?"
