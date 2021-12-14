Feature:
  Scenario:
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    When Hago clic en el boton con id "choose-lang"
    And Espero "1" segundo
    And Hago clic en el boton de "English"
    And Espero "2" segundo
    Then Deberia ver el texto "New in"

  Scenario:
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    When Hago clic en el boton con id "choose-country"
    And Espero "1" segundo
    And Hago clic en el boton de "Albania"
    And Espero "2" segundo
    Then Deberia ver el texto "New in"
